package lesson1.test3;

import lesson1.test3.Box.Box;
import lesson1.test3.Fruit.Apple;
import lesson1.test3.Fruit.Orange;

public class Main {
    public static void main(String[] args){
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Box<Apple> box1 = new Box<Apple>();
        Box<Apple> box2 = new Box<Apple>();
        Box<Orange> box3 = new Box<Orange>();

        box1.addFruit(apple1);
        box1.addFruit(apple2);
        box1.addFruit(apple3);
        box2.addFruit(apple4);
        box2.addFruit(apple5);
        box3.addFruit(orange1);
        box3.addFruit(orange2);

        System.out.println("box1(Apple): " + box1.getWeight());
        System.out.println("box2(Apple): " + box2.getWeight());
        System.out.println("box3(Orange): " + box3.getWeight());

        System.out.println("Сравнение 1 и 3 коробок: " + box1.compare(box3));

        box1.shiftFruit(box2, 2);

        System.out.println("Сравнение 1 и 3 коробок: " + box1.compare(box3));

        System.out.println("box1(Apple): " + box1.getWeight());
        System.out.println("box2(Apple): " + box2.getWeight());
        System.out.println("box3(Orange): " + box3.getWeight());

    }
}
