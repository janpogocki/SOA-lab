package com.parking.simulator;

import com.parking.apisoap.ApiPlaceWSInterface;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jan on 18.06.2017.
 */
public class MainSOAPTester {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/projekt_parking_war_exploded/ApiPlaceWS?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName qname = new QName("http://apisoap.parking.com/", "ApiPlaceWSService");
        Service service = Service.create(url, qname);
        ApiPlaceWSInterface apiPlaceWSInterface = service.getPort(new QName("http://apisoap.parking.com/", "ApiPlaceWSPort"), ApiPlaceWSInterface.class);

        String idStrefy = "all";
        System.out.println("SOAP TESTER\n\nStrefa \"" + idStrefy + "\":\nWolnych miejsc: " + apiPlaceWSInterface.freePlaces(idStrefy)
                + "\nWykaz wolnych miejsc: " + apiPlaceWSInterface.freePlacesList(idStrefy));
    }
}
