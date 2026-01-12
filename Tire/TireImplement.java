package Tire;

public class TireImplement {
    class Tire {
        static class Node {
            Node[] children = new Node[26];
            boolean eow = false;

            Node() {
                for(int i=0; i<children.length; i++) {
                    children[i] = null;
                }
            }
        }

        public static Node root = new Node();

        public static void insert(String word) {
            Node curr = root;
            for(int level=0; level<word.length(); level++) { // O(L)
                int idx = word.charAt(level) - 'a';

                if(curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }

            curr.eow = true;
        }

        public static boolean search(String word) {
            Node curr = root;
            for(int level=0; level<word.length(); level++) { // O(L)
                int idx = word.charAt(level) - 'a';

                if(curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }

            return curr.eow == true;
        }

        /**
         * Word Break Problem
         */

        public static boolean wordBreak(String key) { //O(L)
            if(key.length() == 0) {
                return true;
            }

            for(int i=1; i<key.length(); i++) {
                if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        
    }
}