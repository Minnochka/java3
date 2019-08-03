public class Main {

    public static void main(String[] args){
        ArrClass arrClass = new ArrClass(new int[]{1,4});
        int[] res = arrClass.lastFourArr(new int[]{1,2,3,4,5,6});
        for (int i = 0; i< res.length; i++){
            System.out.println(res[i]);
        }
    }
}
