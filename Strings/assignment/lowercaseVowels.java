package Strings.assignment;

public class lowercaseVowels {

    public  static boolean isLowercaseVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public static int countLowercaseVowels(String text) {
        int count = 0;
        for(int i=0; i<text.length(); i++) {
            if(isLowercaseVowel(text.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String text = "chatgpt is crAzy"; //3
        System.out.println(countLowercaseVowels(text));
    }
}
