package com.parking.simulator;

import com.parking.system.PlaceWSInterface;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jan on 06.06.2017.
 */
public class MainSimulator {
    private static void simulate(){
        Generator generator = new Generator();
        MiejsceParkingowe miejsceParkingowe = new MiejsceParkingowe();

        String car = generator.randomCars();
        int id = generator.randomID(3); // liczba 100-elementowych sektorow parkingowych
        miejsceParkingowe.setId(id);
        System.out.println("\t\tMiejsce: " + id + "\n");

        // send SOAP
        URL url = null;
        try {
            url = new URL("http://localhost:8080/projekt_parking_war_exploded/PlaceWS?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName qname = new QName("http://system.parking.com/", "PlaceWSService");
        Service service = Service.create(url, qname);
        PlaceWSInterface placeWSInterface = service.getPort(new QName("http://system.parking.com/", "PlaceWSPort"), PlaceWSInterface.class);
        placeWSInterface.setOccupied(id, car);

        // --------

        long delayTime = generator.randomTime(5, 15);
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Miejsce: " + id);

        miejsceParkingowe.setCarTable(car);
        System.out.println("Tablica: " + car);

        long currentTime = System.currentTimeMillis();
        miejsceParkingowe.setStartTimestamp(currentTime);
        System.out.println("Obecny czas: " + currentTime);

        long endOffset = generator.randomTime(5, 15);
        long endTime = endOffset + currentTime;
        miejsceParkingowe.setStopTimestamp(endTime);
        System.out.println("Koncowy czas: " + endTime);



        // generate JSON of ticket
        MiejsceParkingoweREST miejsceParkingoweREST = new MiejsceParkingoweREST(car, currentTime + "", endTime + "");
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                .add("carID", miejsceParkingoweREST.carID)
                .add("startTime", miejsceParkingoweREST.startTime)
                .add("stopTime", miejsceParkingoweREST.stopTime);

        JsonObject jsonObject = objectBuilder.build();

        String ticketJSON = "";
        try (Writer writer = new StringWriter()) {
            Json.createWriter(writer).write(jsonObject);
            ticketJSON = writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(ticketJSON);

        // send POST REST of ticket
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080/projekt_parking_war_exploded/rest/ticket/").build());
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, ticketJSON);
        //System.out.println(response);

        Storage.mapOfMiejsceParkingowe.put(id, miejsceParkingowe);
        System.out.println("");

        // wait and send info that place is free
        try {
            Thread.sleep(endOffset + 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // send SOAP that place is free
        placeWSInterface.setFree(id);

        System.out.println("\t\tWycofano ID " + id);
    }

    public static void main(String[] args) {
        /**
         * 1. Losowanie wolnego miejsca
         * 2. Losowanie samochodu
         * 3. Losowanie czasu (w sek.)
         * 4. Losowanie ewentualnej zwoloki (w sek.)
         * 5. Zapisanie do bazy wlasnej
         */

        while (true){
            Thread thread = new Thread() {
                @Override
                public void run() {
                    simulate();
                }
            };

            thread.start();

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
