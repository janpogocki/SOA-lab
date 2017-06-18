package com.parking.system;

/**
 * Created by Jan on 12.06.2017.
 */
public class Ticket {
    private String carID;
    private long startTime;
    private long endTime;

    public Ticket(String carID, long startTime, long endTime) {
        this.carID = carID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
