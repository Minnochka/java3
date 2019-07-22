package Lesson_4;

public class Game {
    Object стул1 = new Object();
    Object стул2 = new Object();

    public static void main(String[] args) {
        Game game = new Game();
        game.startThread();
    }

    void startThread() {
        Thread чел1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Чел1 подошел к стул1");

                synchronized (стул1) {
                    System.out.println("Чел1 сел на стул1");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Чел1 встал со стул1");
                }

            }
        });

        чел1.start();

        Thread чел2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Чел2 подошел к стул1");

                synchronized (стул1) {
                    System.out.println("Чел2 сел на стул1");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Чел2 встал со стул1");
                }

            }
        });
        чел2.start();

        Thread чел3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Чел3 подошел к стул2");

                synchronized (стул2) {
                    System.out.println("Чел3 сел на стул2");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Чел3 встал со стул2");
                }

            }
        });
        чел3.start();
    }
}
