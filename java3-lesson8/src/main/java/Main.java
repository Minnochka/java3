import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[][] arr = new int[10][5];
        for(int i = 0; i < arr.length; i++){
            Arrays.fill(arr[i], 0);
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");

        int[][] arr1 = SpArr(arr, 0, arr.length, 0, arr[0].length, 1);

        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[i].length; j++){
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] SpArr(int[][] arr, int str_f, int str_l, int cln_f, int cln_l, int el){
        if(str_f >= str_l && cln_f >= cln_l){
            return arr;
        }
        if(str_f < str_l){
            for(int j = cln_f; j < cln_l; j++){
                arr[str_f][j] = el++;
            }
            str_f++;
        }
        if(cln_f < cln_l){
            for(int i = str_f; i < str_l; i++){
                arr[i][cln_l - 1] = el++;
            }
            cln_l--;
        }
        if(str_f < str_l){
            for(int j = cln_l - 1; j >= cln_f; j--){
                arr[str_l - 1][j] = el++;
            }
            str_l--;
        }
        if(cln_f < cln_l){
            for(int i = str_l - 1; i >= str_f; i--){
                arr[i][cln_f] = el++;
            }
            cln_f++;
        }
        
        int[][] arr1 = SpArr(arr, str_f, str_l, cln_f, cln_l, el);
        return arr1;
    }
}
