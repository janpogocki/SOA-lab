package com.lab9.zad1;

import org.joda.time.DateTime;
import org.joda.time.Days;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Jan on 30.05.2017.
 */
@WebService
public class Zad1 implements Zad1Interface {
    @WebMethod
    public String getDaysToHolidays() {
        DateTime startDate = new DateTime(DateTime.now());
        DateTime endDate = new DateTime(2017, 7, 1, 0, 0, 0, 0);

        Days days = Days.daysBetween(startDate, endDate);
        int daysInt = days.getDays();

        String returned = "Do wakacji pozostało: " + daysInt + " dni";
        System.out.println(returned);
        return returned;
    }
}
