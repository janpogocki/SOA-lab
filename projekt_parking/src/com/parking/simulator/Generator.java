package com.parking.simulator;

import java.util.Random;

/**
 * Created by Jan on 06.06.2017.
 */
public class Generator {
    public int randomID(int maxSectors){
        Random random = new Random();
        int returned = random.nextInt((maxSectors*100)-1) + 100;

        if (!Storage.listOfIDs.contains(returned)) {
            Storage.listOfIDs.add(returned);
            return returned;
        } else {
            if (Storage.mapOfMiejsceParkingowe.get(returned).getStopTimestamp() < System.currentTimeMillis())
                return returned;
            else
                return randomID(maxSectors);
        }
    }

    public String randomCars(){
        String [] malopolskie = {"KRA", "KOS", "KSU", "KWA"};

        String returned = "";

        Random random = new Random();
        /*returned += (char)(random.nextInt(26) + 'A');
        returned += (char)(random.nextInt(26) + 'A');
        returned += (char)(random.nextInt(26) + 'A');*/

        returned += malopolskie[random.nextInt(4)];

        returned += " ";
        returned += random.nextInt(10);
        returned += random.nextInt(10);
        returned += random.nextInt(10);
        returned += random.nextInt(10);
        returned += random.nextInt(10);

        if (Storage.listOfCars.contains(returned)) {
            Storage.listOfCars.add(returned);
            return randomCars();
        } else
            return returned;
    }

    public long randomTime(int minRange, int maxRange){
        Random random = new Random();
        int returned = random.nextInt(minRange+maxRange)+minRange;

        return returned*1000;
    }
}
