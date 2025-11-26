package Recursion;

public class BinaryStrings {

    public static void printBS(int n, int last, int reset) {
        if(n == 0) {
            System.out.println();
            return;
        }

        if(last == 1) {
            System.out.print("0");
            printBS(n-1, 0, reset);
        } else {
            System.out.print("1");
            printBS(n-1, 1, reset);
            System.out.print("0");
            printBS(n-1, 0, reset);
        }
    }
    public static void main(String[] args) {
        printBS(3, 0, 3);
    }
}
