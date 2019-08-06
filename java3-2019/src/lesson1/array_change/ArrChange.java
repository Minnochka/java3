package lesson1.array_change;

public class ArrChange<Arr_type> {
    private Arr_type[] arr;

    public ArrChange(Arr_type[] arr){
        this.arr = arr;
    }

    public Arr_type[] getArr() {
        return arr;
    }

    public void setArr(Arr_type[] arr) {
        this.arr = arr;
    }

    public void arrFirsToLast(int el1, int el2){
        Arr_type a;
        if(el1 < 0 || el1 >= arr.length || el2 < 0 || el2 >= arr.length){
            System.out.println("Номер элемента больше длинны массива");
        }
        else{
            a = arr[el2];
            arr[el2] = arr[el1];
            arr[el1] = a;
        }
    }

    public void info(){
        System.out.println("-----------------------\nмассив: ");
        for(Arr_type a: this.arr){
            System.out.println(a);
        }
    }
}
