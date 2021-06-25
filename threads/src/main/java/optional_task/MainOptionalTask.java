package optional_task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainOptionalTask {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 11; i++) {
            executorService.submit(new Runway(i));
        }

        executorService.shutdown();
    }
}

class Runway implements Runnable {
    private int id;

    public Runway(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Самолёт " + id + " начал выход на полосу");
            Thread.sleep(1000);
            System.out.println("Самолёт " + id + " взлетел");
            Thread.sleep(1000);
            System.out.println("Полоса \"приняла\" самолёт" + id);
            Thread.sleep(1000);
            System.out.println("Полоса освободилась");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}