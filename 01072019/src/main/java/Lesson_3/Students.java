package Lesson_3;

import java.io.Serializable;

public class Students extends Human implements Serializable {
    int id;
    String name;
    transient Book book;

    public Students(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void info() {
        System.out.println(id + " " + name);
    }
}
