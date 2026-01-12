package Tire;

import java.util.*;

public class PrefixProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int frequency = 0;
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
            curr.frequency++;  
        }

        curr.eow = true;
    }

    public static String search(String word) {
        Node curr = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            prefix.append(word.charAt(i));  

            curr = curr.children[idx];

            if (curr.frequency == 1) {
                return prefix.toString();
            }
        }

        return prefix.toString();
    }

    public static ArrayList<String> prefix(String[] arr) {
        for (String w : arr) insert(w);
        
        ArrayList<String> ans = new ArrayList<>();
        for (String w : arr) ans.add(search(w));

        System.out.println(ans);

        return ans;
    }

    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "dove", "duck"};
        prefix(arr);
    }
}
