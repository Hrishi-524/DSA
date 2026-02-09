package Graphs;

import java.util.*;

public class MST {
    static class Edge {
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));
        
        graph[2].add(new Edge(2, 4, 1));
        graph[2].add(new Edge(2, 0, 1));

        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

        return graph;
    }
    
    public static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] prims(ArrayList<Edge>[] graph) {
        int V = graph.length;
        ArrayList<Edge>[] mst = new ArrayList[V];

        boolean[] vis = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                for(Edge e : graph[curr.v]) {
                    // mst[curr.v].add(new Edge(curr.v, , V))
                
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        
    }
}
