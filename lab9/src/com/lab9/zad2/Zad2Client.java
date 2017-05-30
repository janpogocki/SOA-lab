package com.lab9.zad2;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by Jan on 31.05.2017.
 */
public class Zad2Client {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9000/Zad2Interface?wsdl");
        QName qname = new QName("http://zad2.lab9.com/", "Zad2Service");
        Service service = Service.create(url, qname);

        Zad2Interface zad2Interface = service.getPort(new QName("http://zad2.lab9.com/", "Zad2Port"), Zad2Interface.class);
        zad2Interface.getCurrentCurrency("usd");
        zad2Interface.getCurrentCurrency("eur");
        zad2Interface.getCurrentCurrency("gpb");

        zad2Interface.sellCurrency("usd", 10);
        zad2Interface.sellCurrency("eur", 200);
    }
}
