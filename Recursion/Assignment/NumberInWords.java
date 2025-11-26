package Recursion.Assignment;

public class NumberInWords {
    
    public static String returnWord(int n) {
        if(n == 9) return "Nine";
        if(n == 8) return "Eight";
        if(n == 7) return "Seven";
        if(n == 6) return "Six";
        if(n == 5) return "Five";
        if(n == 4) return "Four";
        if(n == 3) return "Three";
        if(n == 2) return "Two";
        if(n == 1) return "One";
        if(n == 0) return "Zero";
        return "Invalid";
    }

    public static void numToWord(int n) {
        if(n == 0) {
            return;
        }
        numToWord(n/10);
        System.out.print(returnWord(n%10)+" ");
    }

    public static void main(String[] args) {
        int n = 2019;
        numToWord(n);
    }
}
