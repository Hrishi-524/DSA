package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonReapeating {

    public static char firstNonReapeating(String stream) {
        char ans = '!';
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0; i<stream.length(); i++) {
            char curr = stream.charAt(i);
            q.add(curr);
            freq[curr-'a']++;
            while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }
            if (!q.isEmpty()) {
                ans = q.peek();
            } else {
                ans = '!';
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
