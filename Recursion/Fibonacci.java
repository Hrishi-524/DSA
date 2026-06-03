package Recursion;

public class Fibonacci {
    public static int printNthFib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        return printNthFib(n-1)+printNthFib(n-2);
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(printNthFib(n));
    }
}
