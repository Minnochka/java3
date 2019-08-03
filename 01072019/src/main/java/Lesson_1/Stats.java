package Lesson_1;

public class Stats<T extends Number> {
    private T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    public boolean sameAvg(Stats<? super Double> another) {
        return Math.abs(this.avg() - another.avg()) < 0.0001;
    }

}

class StatDemo {
    public static void main(String[] args) {

        Integer[] inums = {1,2,3,4,5};
        Stats<Integer> iob = new Stats<Integer>(inums);
        System.out.println(iob.avg());

//        Integer[] inums123 = {1,2,3,4,5};
//        Stats<Integer> iob123 = new Stats<Integer>(inums123);
//        System.out.println(iob123.avg());

        Double[] inumsD = {1.0,2.0,3.0,4.0,5.0};
        Stats<Double> iobD = new Stats<Double>(inumsD);
        System.out.println(iobD.avg());

        if (iob.sameAvg(iobD)) {
            System.out.println("Средние значения равны!");
        }
    }

//    final public static void t1() {
//
//    }
}


class LamApp {
    public static void main(String[] args) {
        Operator operator = new Operator() {
            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        };

        int res = operator.calculate(10, 20);
        System.out.println(res);
    }
}

interface Operator {
    int calculate(int x, int y);
}





















