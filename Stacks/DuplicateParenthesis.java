package Stacks;

import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean isOpeningBracket(char curr) {
        return (curr == '(' || curr == '[' || curr == '{');
    }

    public static boolean isClosingBracket(char curr) {
        return (curr == ')' || curr == ']' || curr == '}');
    }

    public static boolean isOperator(char curr) {
        return (curr == '+' || curr == '-' || curr == '*' || curr == '/' || curr == '%');
    }

    public static boolean duplicateParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);

            if(!isClosingBracket(curr)) {
                stack.push(curr);
            } else {
                if(isOpeningBracket(stack.peek())) {
                    return true;
                } else {
                    while (!isOpeningBracket(stack.peek())) {
                        stack.pop();
                    }
                    stack.pop();
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "(((a+b+c))+(e*d))";
        System.out.println(duplicateParenthesis(s));
    }
}
