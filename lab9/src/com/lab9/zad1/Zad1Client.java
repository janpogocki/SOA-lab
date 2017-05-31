package com.lab9.zad1;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by Jan on 30.05.2017.
 */
public class Zad1Client {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/lab9_war_exploded/Zad1?wsdl");
        QName qname = new QName("http://zad1.lab9.com/", "Zad1Service");
        Service service = Service.create(url, qname);

        Zad1Interface zad1Interface = service.getPort(new QName("http://zad1.lab9.com/", "Zad1Port"), Zad1Interface.class);
        System.out.println(zad1Interface.getDaysToHolidays());
    }
}
