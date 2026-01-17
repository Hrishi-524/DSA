package Graphs;

import java.util.*;

public class Dijkstra {
    static class Edge {
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int path;

        public Pair(int vertex, int path) {
            this.vertex = vertex;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        return graph;
    }

    public static void dijksra(ArrayList<Edge>[] graph, int src) { // V (boolean or dist loop) + E log V (PQ)
        int[] dist = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if(src != i)
                dist[i] = Integer.MAX_VALUE;
            else 
                dist[i] = 0;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!visited[curr.vertex]) {
                visited[curr.vertex] = true;
                for(int i=0; i<graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = createGraph(V);

        dijksra(graph, 0);
    }
}