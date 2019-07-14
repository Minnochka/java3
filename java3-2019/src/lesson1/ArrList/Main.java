package lesson1.ArrList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        String[] names = new String[]{"Ann", "Mary", "Daniel"};
        for (String name : names) {
            System.out.println(name + " ");
        }
        NewArr newArr = new NewArr();

        ArrayList<String> arrList = newArr.arrToArrList(names);
        System.out.println("---------------------------------------------------ArrayList");
        for (String name : arrList) {
            System.out.println(name + " ");
        }


    }
}
