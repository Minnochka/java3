public class Main {

    private static final Object lock = new Object();
    private static volatile char letter = 'C';

    public static void main(String[] args){

        Thread letterA = new Thread(new Letter('C', 'A'));
        Thread letterB = new Thread(new Letter('A', 'B'));
        Thread letterC = new Thread(new Letter('B', 'C'));

        letterC.setPriority(1);
        letterB.setPriority(2);
        letterA.setPriority(3);


        letterA.start();
        letterB.start();
        letterC.start();

    }

     static class Letter implements Runnable {

         private char myLetter;
         private char lastLetter;

         public Letter(char lastLetter, char myLetter) {
             this.lastLetter = lastLetter;
             this.myLetter = myLetter;
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

}
