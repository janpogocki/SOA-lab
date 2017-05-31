package com.lab9.zad2;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Jan on 31.05.2017.
 */
@WebService()
public class Zad2 implements Zad2Interface {
    private double usd = 3.71;
    private double eur = 4.17;
    private double gpb = 4.8;

    @WebMethod
    public String getCurrentCurrency(String symbol){
        if (symbol.equals("usd")){
            String koszt = "Waluta kosztuje: " + usd + " PLN";
            System.out.println(koszt);
            return koszt;
        }
        else if (symbol.equals("eur")){
            String koszt = "Waluta kosztuje: " + eur + " PLN";
            System.out.println(koszt);
            return koszt;
        }
        else {
            String koszt = "Waluta kosztuje: " + gpb + " PLN";
            System.out.println(koszt);
            return koszt;
        }
    }

    @Override
    public String sellCurrency(String symbol, double amount) {
        if (symbol.equals("usd")){
            String koszt = "Sprzedano za: " + usd*amount + " PLN";
            System.out.println(koszt);
            return koszt;
        }
        else if (symbol.equals("eur")){
            String koszt = "Sprzedano za: " + eur*amount + " PLN";
            System.out.println(koszt);
            return koszt;
        }
        else {
            String koszt = "Sprzedano za: " + gpb*amount + " PLN";
            System.out.println(koszt);
            return koszt;
        }
    }
}
