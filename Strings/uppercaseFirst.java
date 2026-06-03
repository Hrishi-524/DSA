package Strings;

public class uppercaseFirst {
    public static StringBuilder convertUppercaseFirstLetter(StringBuilder sentence) {
        if(sentence.length() == 0) {
            return sentence;
        }
        StringBuilder result = new StringBuilder("");
        result.append(Character.toUpperCase(sentence.charAt(0)));
        for(int i=1; i<sentence.length(); i++) {
            char currChar = sentence.charAt(i);
            char prevChar = sentence.charAt(i-1);
            if(prevChar == ' ') {
                result.append(Character.toUpperCase(sentence.charAt(i)));
            }
            else if(prevChar == ',' && currChar != ' ') {
                result.append(Character.toUpperCase(sentence.charAt(i)));
            }
            else {
                result.append(sentence.charAt(i));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        StringBuilder sentence = new StringBuilder("");
        System.out.println(convertUppercaseFirstLetter(sentence));
    }
}
