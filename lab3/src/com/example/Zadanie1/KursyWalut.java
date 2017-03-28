package com.example.Zadanie1;

import java.util.ResourceBundle;

/**
 * Created by Jan on 28.03.2017.
 */
public class KursyWalut {
    public static double converter(String valIn, String walutaIn, String walutaOut){
        ResourceBundle resource = ResourceBundle.getBundle("waluty");
        double usd = Double.parseDouble(resource.getString("usd"));
        double eur = Double.parseDouble(resource.getString("eur"));
        double chf = Double.parseDouble(resource.getString("chf"));
        double gbp = Double.parseDouble(resource.getString("gbp"));
        double pln = Double.parseDouble(resource.getString("pln"));

        double in2pln = Double.parseDouble(valIn) * Double.parseDouble(resource.getString(walutaIn));
        double pln2out = in2pln / Double.parseDouble(resource.getString(walutaOut));

        return (double) Math.round(pln2out * 100) / 100;
    }
}
