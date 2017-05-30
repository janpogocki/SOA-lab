package com.lab9.zad2;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Jan on 31.05.2017.
 */
@WebService()
public interface Zad2Interface {
    @WebMethod
    public String getCurrentCurrency(String symbol);

    @WebMethod
    public String sellCurrency(String symbol, double amount);
}
