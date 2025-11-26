package Backtracking;

public class KeypadComb {

    public static void keypad(String n, StringBuilder ans, int i) {
        // base case 
        if(i == n.length()) {
            System.out.println(ans);
            return;
        }

        char digit = n.charAt(i);
        StringBuilder mapping = getDigitToString(digit);

        for(int j = 0; j < mapping.length(); j++) {
            ans.append(mapping.charAt(j));
            keypad(n, ans, i + 1);
            ans.deleteCharAt(ans.length() - 1);  // backtrack
        }
    }

    public static StringBuilder getDigitToString(char digit) {
        if(digit == '2') return new StringBuilder("abc");
        if(digit == '3') return new StringBuilder("def");
        if(digit == '4') return new StringBuilder("ghi");
        if(digit == '5') return new StringBuilder("jkl");
        if(digit == '6') return new StringBuilder("mno");
        if(digit == '7') return new StringBuilder("pqrs");
        if(digit == '8') return new StringBuilder("tuv");
        if(digit == '9') return new StringBuilder("wxyz");
        return new StringBuilder(""); // no letters for 0/1
    }

    public static void main(String[] args) {
        String n = "2385468";
        keypad(n, new StringBuilder(), 0);
    }
}
