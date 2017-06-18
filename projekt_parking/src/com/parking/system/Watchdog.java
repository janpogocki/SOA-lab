package com.parking.system;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 * Created by Jan on 17.06.2017.
 */
public class Watchdog {
    private void sendJMS(String carID){
        // send jms czyli wolamy jakis servlet ktory wysyla jms
        int miejsce = Storage.findPlaceIDByCarID(carID);
        int strefa = miejsce / 100;

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080/projekt_parking_war_exploded/ServletSendJMS?carid=" + carID + "&strefa=" + strefa + "&miejsce=" + miejsce).build());
        ClientResponse response = webResource.type(MediaType.TEXT_PLAIN).get(ClientResponse.class);
    }

    private void sendJMSclear(){
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080/projekt_parking_war_exploded/ServletSendJMS?carid=" + "CLEAR" + "&strefa=" + "0" + "&miejsce=" + "0").build());
        ClientResponse response = webResource.type(MediaType.TEXT_PLAIN).get(ClientResponse.class);
    }

    public void start(){
        while (true){
            long currentTime = System.currentTimeMillis();
            sendJMSclear();

            for (int i=0; i<Storage.listOfTickets.size(); i++){
                Ticket current = Storage.listOfTickets.get(i);

                if (currentTime > current.getEndTime()){
                    sendJMS(current.getCarID());
                    System.out.println("send to jms: " + current.getCarID());
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("." + Storage.listOfTickets.size());
        }
    }
}
