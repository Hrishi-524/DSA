package Stacks;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isMatchingOpposite(char opening, char closing) {
        if(opening == '(' && closing == ')' || opening == '[' && closing == ']' || opening == '{' && closing == '}') return true;
        else return false;
    }

    public static boolean validParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);

            if(curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else {
                if(!stack.isEmpty() && isMatchingOpposite(stack.peek(), curr)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "({[";
        System.out.println(validParenthesis(s));// true

    }
}
