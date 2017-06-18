package com.parking.simulator;

/**
 * Created by Jan on 06.06.2017.
 */
public class MiejsceParkingowe {
    private int id;
    private String carTable;
    private long startTimestamp;
    private long stopTimestamp;
    private long delay;

    public String getCarTable() {
        return carTable;
    }

    public void setCarTable(String carTable) {
        this.carTable = carTable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public long getStopTimestamp() {
        return stopTimestamp;
    }

    public void setStopTimestamp(long stopTimestamp) {
        this.stopTimestamp = stopTimestamp;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }
}
