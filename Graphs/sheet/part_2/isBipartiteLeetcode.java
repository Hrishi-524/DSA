package Graphs.sheet.part_2;
import java.util.*;

public class isBipartiteLeetcode {
    class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V]; // 0 = no color; 1 = yellow; 2 = blue

        for (int i = 0; i < V; i++) {
            if (color[i] == 0) { // not colored yet
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 1; // start with yellow

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int nb : graph[curr]) {
                        if (color[nb] == 0) {
                            // assign opposite color
                            color[nb] = (color[curr] == 1) ? 2 : 1;
                            q.add(nb);
                        } else if (color[nb] == color[curr]) {
                            return false; // same color conflict
                        }
                    }
                }
            }
        }
        return true;
    }
}

}
