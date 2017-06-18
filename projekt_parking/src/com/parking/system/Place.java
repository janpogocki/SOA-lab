package com.parking.system;

/**
 * Created by Jan on 12.06.2017.
 */
public class Place {
    private int id;
    private long timeOfLastOccupied;
    private String carID;

    public Place(int id, long timeOfLastOccupied, String carID) {
        this.id = id;
        this.timeOfLastOccupied = timeOfLastOccupied;
        this.carID = carID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimeOfLastOccupied() {
        return timeOfLastOccupied;
    }

    public void setTimeOfLastOccupied(long timeOfLastOccupied) {
        this.timeOfLastOccupied = timeOfLastOccupied;
    }
}
