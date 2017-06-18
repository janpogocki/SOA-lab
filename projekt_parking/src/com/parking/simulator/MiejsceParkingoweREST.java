package com.parking.simulator;

/**
 * Created by Jan on 06.06.2017.
 */
public class MiejsceParkingoweREST {
    public String carID;
    public String startTime;
    public String stopTime;

    public MiejsceParkingoweREST(String carID, String startTime, String stopTime) {
        this.carID = carID;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }
}
