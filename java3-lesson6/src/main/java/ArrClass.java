import java.util.ArrayList;

public class ArrClass {
    ArrayList<Integer> checkedInt = new ArrayList<Integer>();

    public boolean CheckArr(int[] arr){
        boolean res = false;
        for(int c : checkedInt){
            for(int i = 0; i < arr.length; i++){
                if(c == arr[i]){
                    res = true;
                    break;
                }
            }
            if(res == true){
                break;
            }
        }
        return res;
    }

    public int[] lastFourArr(int[] arr){
        int num = 4;
        boolean isFound = false;
        int start = 0;
        int[] res;
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num) {
                start = i + 1;
                isFound = true;
                break;
            }
        }
        if(isFound == true) {
            for (int i = start; i < arr.length; i++) {
                if (arr[i] != num) {
                    arrList.add(arr[i]);
                } else {
                    arrList.clear();
                }
            }
            res = new int[arrList.size()];
            for (int i = 0; i < arrList.size(); i++) {
                res[i] = arrList.get(i);

            }
        }
        else{
            throw new RuntimeException();
        }

        return res;
    }

    public ArrClass(int[] checkedInt){
        for (int i=0; i < checkedInt.length; i++){
            this.checkedInt.add(checkedInt[i]);
        }
    }
}
