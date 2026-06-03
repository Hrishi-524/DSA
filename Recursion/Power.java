package Recursion;

public class Power {
    public static int xPowN(int x, int n) {
        return n == 1 ? x : x * xPowN(x, n-1);
    }

    public static int xPowNOptimized(int x, int n) {
        if(n == 1) {
            return x;
        }
        int half = xPowNOptimized(x, n/2);
        if(n%2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
    public static void main(String[] args) {
        System.out.println(xPowN(2, 10));
        System.out.println(xPowNOptimized(2, 10));
    }
}
