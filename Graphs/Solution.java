package Graphs;
import java.util.*;

class Solution {
    static class Edge {
        int dest;
        int wt;

        public Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    @SuppressWarnings("unchecked")
    public void loudAndRich(int[][] richer, int[] quiet) {
        int V = quiet.length, E = richer.length;
        int[] answer = new int[V];
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<V; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<E; i++) {
            int src = richer[i][1];
            int dest = richer[i][0];
            int wt = quiet[src] - quiet[dest];
            graph[src].add(new Edge(dest, wt));
        }

        boolean[] vis = new boolean[V];
        
        // for each vertices we need answer
        for(int vertex=0; vertex<V; vertex++) {
            answer[vertex] = dfs(graph, vis, vertex, answer, quiet);
        }
    }

    public static int dfs(ArrayList<Edge>[] graph, boolean[] vis, int vertex, int[] answer, int[] quiet) {
        // visit current vertex
        vis[vertex] = true;

        // explore all neighbours and take the maximum wt
        int maxWt = Integer.MIN_VALUE;
        int nextVertex = -1;
        for(Edge e : graph[vertex]) {
            int nb = e.dest;
            int wt = e.wt;
            if(wt > maxWt) {
                nextVertex = nb;
            }
        }

        if(nextVertex == -1) {
            answer[vertex] = vertex;
            return answer[vertex];
        }

        answer[vertex] = Math.min(quiet[vertex], dfs(graph, vis, nextVertex, answer, quiet));

        return answer[vertex];
    }
}