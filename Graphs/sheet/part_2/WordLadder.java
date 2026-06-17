package Graphs.sheet.part_2;

import java.util.*;

public class WordLadder {
    class Solution {
    class Pair {
        String s;
        int count;
        Pair(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();

        q.add(new Pair(beginWord, 1));
        vis.add(beginWord);

        while (!q.isEmpty()) {
            Pair curr = q.remove();

            if (curr.s.equals(endWord)) return curr.count;

            List<String> neighbours = validNeighbours(curr.s, set);

            for (String nb : neighbours) {
                if (!vis.contains(nb)) {
                    q.add(new Pair(nb, curr.count + 1));
                    vis.add(nb);
                }
            }
        }
        
        return 0; // no path found
    }

    List<String> validNeighbours(String s, HashSet<String> set) {
        List<String> neighbours = new ArrayList<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                arr[i] = c;
                String newWord = new String(arr);
                if (set.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }
            arr[i] = original; // restore
        }
        return neighbours;
    }
}

}
