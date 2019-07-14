package lesson1.array_change;

public class Main {
    public static void main(String[] args) {
        String[] names = new String[] { "Tom", "Jerry" };

        ArrChange<String> arr1 = new ArrChange<String>(names);
        //Integer[] arr2 = {1, 5, 6, 7, 9};
        ///Double[] arr3 = {1.0, 7.0, 8.0};
        arr1.info();
        arr1.arrFirsToLast(0, 1);
        arr1.info();

        Integer[] ages = new Integer[]{12,14,22,65,10,98};
        ArrChange<Integer> arr2 = new ArrChange<Integer>(ages);
        //Integer[] arr2 = {1, 5, 6, 7, 9};
        ///Double[] arr3 = {1.0, 7.0, 8.0};
        arr2.info();
        arr2.arrFirsToLast(4, 1);
        arr2.info();
    }
}