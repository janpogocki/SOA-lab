package com.example.faces;

import javax.faces.bean.ManagedBean;

/**
 * Created by Jan on 04.04.2017.
 */

@ManagedBean
public class Szansa {
    public String wyslij() {
        if (Math.random() < 0.2 ) {
            return "wygrana";
        } else {
            return "przegrana";
        }
    }
}