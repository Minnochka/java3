import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    CountDownLatch cdlReady, cdlFinish;
    ArrayBlockingQueue<String> queue;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch cdlReady, CountDownLatch cdlFinish, ArrayBlockingQueue queue) {
        this.race = race;
        this.speed = speed;
        this.cdlFinish = cdlFinish;
        this.cdlReady = cdlReady;
        this.queue = queue;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlReady.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(cdlReady.getCount() + " " + Thread.currentThread());
        while (cdlReady.getCount() > 0) //Проверяем, собрались ли все автомобили
        {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdlFinish.countDown();
        queue.offer(name);
    }
}
