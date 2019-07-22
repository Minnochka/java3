package Lesson_2;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    private static int factorial(int n) {
        int result = 1;
        if (n == 0) {
            return result;
        }
        System.out.println(n);
        result = n * factorial(n-1);
        return result;
    }
}
