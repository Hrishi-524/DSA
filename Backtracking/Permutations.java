package Backtracking;

public class Permutations {
    public static void permutation(String str, String ans) {
        //base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //kaam and backtarck kaam
        for(int i=0; i<str.length(); /*(Backtarcking)*/i++/**BackTrack and see for any other character*/) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            permutation(newStr, ans+ch);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        permutation(str, "");
    }
}
