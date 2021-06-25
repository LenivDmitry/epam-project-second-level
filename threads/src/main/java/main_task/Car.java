package main_task;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    private int carId;
    private int waitingTimeSeconds;

    public Car(int carId, int waitingTimeSeconds) {
        this.carId = carId;
        this.waitingTimeSeconds = waitingTimeSeconds;
    }

    @Override
    public void run() {
        Semaphore parking = Parking.getInstance().getParking();
        System.out.println("Автомобиль " + carId + " стал в очередь");
        try {
            boolean availablePlaces = parking.tryAcquire(1, waitingTimeSeconds, TimeUnit.SECONDS);
            if (!availablePlaces) {
                System.out.println("Автомобиль " + carId + " уехал на другую стоянку");
                return;
            }
            System.out.println("Автомобиль " + carId + " занял парковочное место");
            int timeOnParking = ThreadLocalRandom.current().nextInt(5, 16);

            Thread.sleep(timeOnParking * 1000);

            System.out.println("Автомобиль " + carId + " освободил парковочное место");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            parking.release();
        }
    }
}
