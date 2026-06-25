package Graphs.sheet.part_4;

import java.util.*;

public class ShortestDAG {
    class Solution {
        class Pair {
            int n, w;
            Pair(int n, int w) {
                this.n = n;
                this.w = w;
            }
        }

        public int[] shortestPath(int N, int M, int[][] edges) {
            ArrayList<ArrayList<Pair>> g = new ArrayList<>();
            for(int i = 0; i < N; i++) g.add(new ArrayList<>());

            // Build directed graph
            for(int i = 0; i < M; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int w = edges[i][2];
                g.get(u).add(new Pair(v, w));
            }

            Stack<Integer> stack = new Stack<>();
            boolean[] vis = new boolean[N];

            // Topological sort
            for(int i = 0; i < N; i++) {
                if(!vis[i]) dfsUtil(i, g, vis, stack);
            }

            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0; // source node

            // Relax edges in topological order
            while(!stack.isEmpty()) {
                int curr = stack.pop();
                if(dist[curr] != Integer.MAX_VALUE) {
                    for(Pair p : g.get(curr)) {
                        int nb = p.n;
                        int wt = p.w;
                        if(dist[curr] + wt < dist[nb]) {
                            dist[nb] = dist[curr] + wt;
                        }
                    }
                }
            }

            // Replace unreachable nodes with -1
            for(int i = 0; i < N; i++) {
                if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
            }

            return dist;
        }

        void dfsUtil(int curr, ArrayList<ArrayList<Pair>> g, boolean[] vis, Stack<Integer> stack) {
            vis[curr] = true;
            for(Pair p : g.get(curr)) {
                if(!vis[p.n]) dfsUtil(p.n, g, vis, stack);
            }
            stack.push(curr);
        }
    }
}
