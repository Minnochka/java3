package Lesson_4;

public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println(getName());
    }

    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();

        t1.setPriority(2);
        t2.setPriority(1);

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        t1.start();
        t2.start();
    }
}
