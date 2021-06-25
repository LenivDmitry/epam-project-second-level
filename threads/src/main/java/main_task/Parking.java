package main_task;

import java.util.concurrent.Semaphore;

public class Parking {
    private static Parking instance;
    private Semaphore parking;

    private Parking() {

    }

    public static Parking getInstance() {
        if (instance == null) {
            instance = new Parking();
        }
        return instance;
    }

    public Semaphore getParking() {
        return parking;
    }

    public void setParking(Semaphore parking) {
        this.parking = parking;
    }
}
