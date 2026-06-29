package Graphs.sheet.part_5;

import java.util.ArrayList;
import java.util.HashSet;

public class OperNetworkConn {
    class Solution3 {
        public int makeConnected(int n, int[][] connections) {
            int E = connections.length;
            if (E < n - 1) return -1;

            int[] par = new int[n];
            int[] rank = new int[n];
            for (int i = 0; i < n; i++) par[i] = i;

            int merges = 0;
            for (int[] edge : connections) {
                if (union(edge[0], edge[1], par, rank)) {
                    merges++;
                }
            }

            // number of components = n - merges
            int components = n - merges;
            return components - 1;
        }

        int find(int x, int[] par) {
            if (x == par[x]) return x;
            return par[x] = find(par[x], par);
        }

        boolean union(int a, int b, int[] par, int[] rank) {
            int pa = find(a, par);
            int pb = find(b, par);

            if (pa == pb) return false; // already in same set, no merge

            if (rank[pa] == rank[pb]) {
                rank[pb]++;
                par[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                par[pb] = pa;
            } else {
                par[pa] = pb;
            }
            return true; // merge happened
        }
    }

    class Solution2 {
        public int makeConnected(int n, int[][] connections) {
            int E = connections.length;
            if(E < n-1) return -1;

            int[] par = new int[n];
            int[] rank = new int[n];

            for(int i=0; i<n; i++) {
                par[i] = i;
            }
            
            for(int i=0; i<E; i++) {
                int src = connections[i][0];
                int dest = connections[i][1];

                union(src, dest, par, rank);
            }

            HashSet<Integer> set = new HashSet<>();
            for(int i=0; i<n; i++) {
                set.add(find(i, par));
            }

            return set.size()-1;
        }

        int find(int x, int[] par) {
            if(x == par[x]) return x;
            return par[x] = find(par[x], par);
        }

        void union(int a, int b, int[] par, int[] rank) {
            int parA = find(a, par);
            int parB = find(b, par);

            if(rank[parA] == rank[parB]) {
                rank[parB]++;
                par[parA] = parB;
            } else if (rank[parA] > rank[parB]) {
                par[parB] = parA;
            } else { // rank[parA] < rank[parB]
                par[parA] = parB;
            }
        }
}
    class Solution {
        @SuppressWarnings("unchecked")
        public int makeConnected(int n, int[][] connections) {
            int E = connections.length;
            if(E < n-1) return -1;

            ArrayList<Integer>[] graph = new ArrayList[n];
            for(int i=0; i<n; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++) {
                int src = connections[i][0];
                int dest = connections[i][1];

                graph[src].add(dest);
                graph[dest].add(src);
            }

            boolean[] vis = new boolean[n];

            int nConn = 0;
            for(int i=0; i<n; i++) {
                if(!vis[i]) {
                    dfs(i, graph, vis);
                    nConn++;
                }
            }

            return nConn-1;
        }

        void dfs(int curr, ArrayList<Integer>[] graph, boolean[] vis) {
            vis[curr] = true;

            for(int nb: graph[curr]) {
                if(!vis[nb]) {
                    dfs(nb, graph, vis);
                }
            }
        }
    }
}
