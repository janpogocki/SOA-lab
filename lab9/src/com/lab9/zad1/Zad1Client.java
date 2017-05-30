package com.lab9.zad1;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by Jan on 30.05.2017.
 */
public class Zad1Client {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9000/Zad1Interface?wsdl");
        QName qname = new QName("http://zad1.lab9.com/", "Zad1Service");
        Service service = Service.create(url, qname);

        Zad1Interface zad1Interface = service.getPort(new QName("http://zad1.lab9.com/", "Zad1Port"), Zad1Interface.class);
        zad1Interface.getDaysToHolidays();
    }
}
