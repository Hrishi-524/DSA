package Strings;

import java.util.*;

public class OaAdobe {
    public static String language(String t) {
        int n = t.length();

        int i=0, j=n-1;
        StringBuilder sb = new StringBuilder("");
        while(i < j) {
            while(t.charAt(i) == 'i') {
                System.out.println("Found 'i' at index " + i);
                i++;
            }
            if(t.charAt(i) != 'i' && t.charAt(i) == t.charAt(j)) {
                sb.append(t.charAt(i));
                System.out.println("Appending '" + t.charAt(i) + "' to result");
            }
            if(t.charAt(i) != 'i' && t.charAt(i) != t.charAt(j)) {
                System.out.println("Found mismatch at indices " + i + " and " + j);
                return "notpossible";
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        System.out.println(language(input));

        sc.close();
    }
}
