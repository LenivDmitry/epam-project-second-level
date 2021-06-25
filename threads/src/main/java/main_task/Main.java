package main_task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int cars = 20;
        int carsPlaces = 5;
        int waitingTimeSeconds = 10;

        Parking.getInstance().setParking(new Semaphore(carsPlaces));
        ExecutorService executorService = Executors.newFixedThreadPool(cars);

        for (int i = 1; i <= cars; i++) {
            executorService.submit(new Car(i, waitingTimeSeconds));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
