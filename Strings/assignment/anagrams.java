package Strings.assignment;

import java.util.Arrays;

public class anagrams {
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(arr1.length == arr2.length) {
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
