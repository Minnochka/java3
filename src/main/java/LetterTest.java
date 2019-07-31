public class LetterTest implements Runnable {

    private volatile char letter = 'C';
    private char myLetter;
    private char lastLetter;
    private Object lock;

    public LetterTest(char lastLetter, char myLetter, Object lock) {
        this.lastLetter = lastLetter;
        this.myLetter = myLetter;
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            int cnt = 5;
            // System.out.println("start " + myLetter);
            while (cnt > 0) {
                //System.out.println("currentletter: " + letter + " currentData " + myLetter + "-" + lastLetter);
                while (letter != lastLetter) {
                    try {
                        //System.out.println("waiting " + letter + " " + lastLetter);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                letter = myLetter;
                System.out.print(letter);
                lock.notifyAll();
                cnt--;
            }
        }
    }
}