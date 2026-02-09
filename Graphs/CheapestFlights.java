package Graphs;

import java.util.ArrayList;

public class CheapestFlights {
    static class Edge {
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createGraph(int[][] flights, int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : flights) {
            int src = e[0];
            int dest =  e[1];
            int wt = e[2];
            graph[src].add(new Edge(src, dest, wt));
        }  

        return graph;
    }

    public static void main(String[] args) {
    
    }
}