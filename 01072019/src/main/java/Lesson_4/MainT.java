package Lesson_4;

public class MainT {
    public static void main(String[] args) {
//        MyThread t1 = new MyThread();
//        t1.start();
//
//        Thread t2 = new Thread(new MyRunnableClass());
//        t2.start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("start!");
//            }
//        }).start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(1);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();

        while (true) {
            if(!t1.isAlive()) {
                break;
            }
        }

        System.out.println("END");

    }
}


class MyRunnableClass implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}