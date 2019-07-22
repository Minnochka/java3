package lesson1.ArrList;

import java.util.ArrayList;

public class NewArr<ArrType> {
    /*ArrType[] arr;
    ArrayList<ArrType> arrList;

    public NewArr(ArrType[] arr){
        this.arr = arr;
    }

    public ArrayList<ArrType> getArrList() {
        return arrList;
    }

    public void setArr(ArrType[] arr) {
        this.arr = arr;
    }*/

    public ArrayList<ArrType> arrToArrList(ArrType[] arr){
        ArrayList<ArrType> arrList = new ArrayList<ArrType>();
        for(ArrType a: arr){
            arrList.add(a);
        }
        return arrList;
    }

    /*public ArrType[] arrChangeEls(ArrType[] arr, int el1, int el2){
        ArrType a;
        if(el1 < 0 || el1 >= arr.length || el2 < 0 || el2 >= arr.length){
            System.out.println("Номер элемента больше длинны массива");
        }
        else{
            a = arr[el2];
            arr[el2] = arr[el1];
            arr[el1] = a;
        }
        return (ArrType[])arr;
    }*/
}
