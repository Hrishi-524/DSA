package Recursion.Assignment;

public class LengthOfString {
    public static int length(String str, int i) {
        if(i == str.length()-1) {
            return 1;
        }
        return 1 + length(str, i+1);
    }
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(length(str, 0));
    }
}
