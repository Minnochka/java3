package Lesson_3;

import java.io.*;

public class MainStudents {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Students s = new Students(1, "Bob");
//        Book book = new Book("Jungle");
//        s.book = book;
//
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud.ser"));
//        oos.writeObject(s);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud.ser"));
        Students s2 = (Students) ois.readObject();
        s2.info();
        ois.close();
    }
}
