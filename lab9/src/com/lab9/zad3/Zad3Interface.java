package com.lab9.zad3;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Jan on 31.05.2017.
 */

@WebService
public interface Zad3Interface {
    @WebMethod
    public String getStringStats(String str);
}
