package com.lab9.zad3;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by Jan on 31.05.2017.
 */
public class Zad3Client {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9000/Zad3Interface?wsdl");
        QName qname = new QName("http://zad3.lab9.com/", "Zad3Service");
        Service service = Service.create(url, qname);

        Zad3Interface zad3Interface = service.getPort(new QName("http://zad3.lab9.com/", "Zad3Port"), Zad3Interface.class);
        zad3Interface.getStringStats("test TEST 1234");
    }
}
