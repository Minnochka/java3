package Lesson_1;

import java.util.ArrayList;

public class Lesson_1 {
    public static void main(String[] args) {
//        Box box1 = new Box(1);
//        Box box2 = new Box("asd");
//
////        box1.info();
////        box2.info();
//
//        int x = 10;
//        x = x + (Integer) box2.getObj();
//        System.out.println(x);

//        BoxUltimate<String> boxStr = new BoxUltimate<>("Hello");
//        BoxUltimate<Integer> boxInt = new BoxUltimate<>(123);
//
////        boxStr.info();
////        boxInt.info();
//
//        if (boxStr instanceof BoxUltimate) {
//            System.out.println("Универсальный ящик1");
//        }
//
//        if (boxInt instanceof BoxUltimate) {
//            System.out.println("Универсальный ящик2");
//        }

//        boxInt = boxStr;
//        boxStr = boxInt;
//
//        int x = 10;
//        x = x + boxInt.getObj();
//        System.out.println(x);

//        ArrayList<String> al = new ArrayList<>();
//
//        TwoGen<Integer, String> twoGen = new TwoGen<Integer, String>(555, "Hello");
//
//        twoGen.showType();
//
//        int y = twoGen.getObj1();
//        String s = twoGen.getObj2();
//
//        System.out.println(y);
//        System.out.println(s);



    }
}

class BoxInt {
    private Integer obj;

    public BoxInt(Integer obj) {
        this.obj = obj;
    }

    public Integer getObj() {
        return obj;
    }

    public void setObj(Integer obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("obj " + obj);
        System.out.println("type " + obj.getClass());
    }
}


class Box {
    private Object obj;

    public Box(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("obj " + obj);
        System.out.println("type " + obj.getClass());
    }
}
