package Recursion.Assignment;

public class ContiguousSubstrings {

    public static int contiguousSubStr(String str, int i, int j) {
        if(i >= str.length()) {
            return 0;
        }
        if(j >= str.length()) {
            return contiguousSubStr(str, i+1, i+1);
        }
        if(str.charAt(i) == str.charAt(j)) {
            return 1 + contiguousSubStr(str, i, j+1);
        } else {
            return contiguousSubStr(str, i, j+1);
        }
        
    }
    public static void main(String[] args) {
        String str = "abcab";
        System.out.println(contiguousSubStr(str, 0, 0));
    }
}
