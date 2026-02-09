package Graphs;
import java.util.*;

public class Bellman {
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

        graph[0].add(new Edge(0, 1, 1));
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

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];

        for (int i = 0; i < dist.length; i++) {
            if(dist[i] != src) 
                dist[i] = Integer.MAX_VALUE;
        }

        // O(V * E)
        for(int i=0; i<V-1; i++) {
            for(int j=0; j<V; j++) {
                for(Edge e : graph[i]) {
                    if(dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest]) {
                        dist[e.dest] = dist[e.src] + e.wt;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        
    }
}