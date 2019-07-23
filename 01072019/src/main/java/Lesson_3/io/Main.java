package Lesson_3.io;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
//        File file = new File("123");
//        String[] str = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.endsWith(".txt");
//            }
//        });
//
//        for (String o:str) {
//            System.out.println(o);
//        }

//        File file = new File("123/test2.txt");
//        file.createNewFile();

//        System.out.println(file);


        //file.mkdirs();

//        long t = System.currentTimeMillis();
//        try (FileInputStream in = new FileInputStream("123/test.txt")){
//            int x;
//
//            while ((x = in.read()) != -1) {
//                System.out.print((char) x);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() - t);


//        long t = System.currentTimeMillis();
//        try (FileInputStream in = new FileInputStream("123/test.txt")){
//            byte[] arr = new byte[512];
//            int x;
//
//            while ((x = in.read(arr)) > 0) {
//                System.out.print(new String(arr, 0 , x));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() - t);


//        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("123/test.txt"), "UTF-8")) {
//            int x;
//
//            while ((x = isr.read()) != -1) {
//                System.out.print((char) x);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        BufferedReader br = null;
//        FileReader fr = null;
//
//        fr = new FileReader("123/test.txt");
//        br = new BufferedReader(fr);
//
//        String str;
//        while ((str = br.readLine()) != null) {
//            System.out.println(str);
//        }


//        PipedInputStream in = null;
//        PipedOutputStream out = null;
//
//        in = new PipedInputStream();
//        out = new PipedOutputStream();
//
//        out.connect(in);


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    out.write(i);
//                }
//            }
//        }).start();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int x;
//                while ((x = in.read()) != -1) {
//                    System.out.println(x);
//                }
//            }
//        }).start();


//        ArrayList<InputStream> ali = new ArrayList<>();
//        ali.add(new FileInputStream("123/test.txt"));
//        ali.add(new FileInputStream("123/test2.txt"));
//        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));
//
//        int x;
//        while ((x = in.read()) != -1) {
//            System.out.print((char) x);
//        }

//        try(RandomAccessFile raf = new RandomAccessFile("123/test.txt", "r")) {
//            raf.seek(2);
//            System.out.println((char) raf.read());
//        }
    }
}
