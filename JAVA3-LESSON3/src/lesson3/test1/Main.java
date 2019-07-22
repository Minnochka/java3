package lesson3.test1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("src/lesson3/test1/text1.txt");
        byte[] arr = new byte[10];
        int x;
        while(true){
            if (((x = in.read(arr)) > 0)) {
                    //System.out.println("x=" + x);
                    System.out.print(new String(arr, 0, x));
                }
            else{
                break;
            }

        }
        in.close();
    }
}