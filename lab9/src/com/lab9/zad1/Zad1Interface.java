package com.lab9.zad1;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Jan on 30.05.2017.
 */

@WebService()
public interface Zad1Interface {
    @WebMethod
    public String getDaysToHolidays();
}
