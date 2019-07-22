package lesson3.test2;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        byte[] arr = new byte[10];
        int x;
        String path = "src/lesson3/test2";
        File file = new File(path);
        FileOutputStream out = new FileOutputStream(path + "/" + "AllText.txt");
        ArrayList<FileInputStream> al = new ArrayList<>();

        String[] files = file.list(new FilenameFilter(){
            @Override public boolean accept(File folder, String name) {
                return (name.startsWith("text") && name.endsWith(".txt"));
            }
        });
        for(String s : files){
            al.add(new FileInputStream(path + "/" + s));

        }
        out.write("".getBytes());
        out.close();
        out = new FileOutputStream(path + "/" + "AllText.txt", true);
        for(FileInputStream a: al){
            while(true){
                if (((x = a.read(arr)) > 0)) {
                    out.write(arr, 0, x);
                }
                else{
                    a.close();
                    break;
                }
            }
        }
        out.close();
    }
}