package com.parking.system;

import java.util.*;

/**
 * Created by Jan on 12.06.2017.
 */
public class Storage {
    public static List<Place> listOfPlaces = new ArrayList<>();
    public static List<Ticket> listOfTickets = new ArrayList<>();
    public static Map<String, List<Long[]>> archiveListOfTickets = new TreeMap<>();
    public static Map<Integer, Integer> archiveMostUsedPlaces = new TreeMap<>();

    public static int findPlaceByPlaceID(int id){
        for (int i=0; i<listOfPlaces.size(); i++){
            if (listOfPlaces.get(i).getId() == id)
                return i;
        }

        return -1;
    }

    public static int findPlaceIDByCarID(String carID){
        for (int i=0; i<listOfPlaces.size(); i++){
            if (listOfPlaces.get(i).getCarID().equals(carID))
                return listOfPlaces.get(i).getId();
        }

        return -1;
    }

    public static int findTicketByCarID(String carID){
        for (int i=0; i<listOfTickets.size(); i++){
            if (listOfTickets.get(i).getCarID().equals(carID))
                return i;
        }

        return -1;
    }
}
