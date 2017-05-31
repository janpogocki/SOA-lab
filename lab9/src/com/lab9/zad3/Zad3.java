package com.lab9.zad3;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by Jan on 31.05.2017.
 */
@WebService
public class Zad3 implements Zad3Interface {
    private int getUppercase(String str){
        int returned = 0;

        for (int i=0; i<str.length(); i++)
            if (Character.isUpperCase(str.charAt(i))) returned++;

        return returned;
    }

    private int getLowercase(String str){
        int returned = 0;

        for (int i=0; i<str.length(); i++)
            if (Character.isLowerCase(str.charAt(i))) returned++;

        return returned;
    }

    private int getDigits(String str){
        int returned = 0;

        for (int i=0; i<str.length(); i++)
            if (Character.isDigit(str.charAt(i))) returned++;

        return returned;
    }

    private int getWhitespaces(String str){
        int returned = 0;

        for (int i=0; i<str.length(); i++)
            if (Character.isWhitespace(str.charAt(i))) returned++;

        return returned;
    }

    @WebMethod
    public String getStringStats(String str) {
        int iloscZnakow = str.length();
        int iloscBialychZnakow = getWhitespaces(str);
        int duzeLitery = getUppercase(str);
        int maleLitery = getLowercase(str);
        int iloscCyfr = getDigits(str);

        String returned = str + "\n\nZnaków:\t" + iloscZnakow + "\nBialych znakow:\t" + iloscBialychZnakow + "\nDuzych liter:\t" +
                duzeLitery + "\nMalych liter:\t" + maleLitery + "\nCyfry:\t" + iloscCyfr;
        System.out.println(returned);
        return returned;
    }

    public static void main(String[] args) {
        Object implementor = new Zad3();
        String address = "http://localhost:9000/Zad3";
        Endpoint.publish(address, implementor);
    }
}
