package Bit;

public class EvenOdd {
    public static boolean isEven(int n) {
        //bitMask = 1 << 0 (genralizing to get ith element bitMask should be 1 << i , here i = 0)
        return (n & 1) == 0;
    }
    public static void main(String[] args) {
        int n = 27;
        System.out.println(isEven(n));
    }
}
