package Graphs.sheet.part_2;
import java.util.*;
public class ConnectedN {
    class Solution {
        public int findNumberOfComponent(int V, List<List<Integer>> edges) {
            boolean[] vis = new boolean[V];
            int nConnected = 0;

            for(int i=0; i<V; i++) {
                if(!vis[i]) {
                    dfsUtil(i, V, edges, vis);
                    nConnected++;
                }
            }

            return nConnected;
        }

        void dfsUtil(int curr, int V, List<List<Integer>> edges, boolean[] vis) {
            vis[curr] = true;

            for(int i=0; i<edges.size(); i++) {
                int src = edges.get(i).get(0);
                int dest = edges.get(i).get(1);
                if(src == curr && !vis[dest]) {
                    dfsUtil(dest, V, edges, vis);
                }
            }
        }
    }
}