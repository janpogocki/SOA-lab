package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 23.03.2017.
 */
public class EkspertPiwny {
    public List<String> getMarki(String kolor){
        List<String> marki = new ArrayList();
        if (kolor.equals("jasny")) {
            marki.add("Perła");
            marki.add("Żywiec");
        }
        if (kolor.equals("bursztynowy")) {
            marki.add("Lech");
            marki.add("Żywiec");
        }
        if (kolor.equals("brazowy")) {
            marki.add("Książęce");
            marki.add("Fortuna");
        }
        if (kolor.equals("ciemny")) {
            marki.add("Strong");
            marki.add("Palone");
        }


        return marki;
    }
}
