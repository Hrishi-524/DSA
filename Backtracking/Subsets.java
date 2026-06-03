package Backtracking;

public class Subsets {
    public static void findSubsets(String str, String subset, int i) {
        if(i == str.length()) {
            if(subset.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(subset);
            }
            return;
        }

        //yes choice
        findSubsets(str, subset+str.charAt(i), i+1);
        //no choice
        findSubsets(str, subset, i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str, "", 0);
    }
}
