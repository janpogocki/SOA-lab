package com.zadanie5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 05.04.2017.
 */
public class Counter5 {
    private static List<Integer> listOfClicks = new ArrayList<>();

    public String getClicks(int index){
        if (listOfClicks.size() > index)
            return listOfClicks.get(index).toString();
        else
            return "0";
    }

    public void increment(int index){
        if (listOfClicks.size() > index)
            listOfClicks.set(index, listOfClicks.get(index)+1);
        else
            listOfClicks.add(1);
    }
}
