package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipirate {
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

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i=0; i<graph.length; i++) {
            if(color[i] == -1) {
                if(!isBipartiteUtil(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int src, int[] color) {
        Queue<Integer> q = new LinkedList<>();

        color[src] = 0;
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.remove();
            for(Edge e : graph[curr]) {
                if(color[e.dest] == -1) {
                    // color[e.dest] = color[curr] == 0 ? 1 : 0;
                    color[e.dest] = 1 - color[curr];
                    q.add(e.dest);
                }
                else if(color[e.dest] == color[curr]) {
                    return false;
                }  
            }
        }

        return true;
    }


    public static void main(String[] args) {
        /*
              0
             / \
            1   2
            |   |
            3 - 4    
        */
        int V=5;
        ArrayList<Edge>[] graph = createGraph(V);
        System.out.println(isBipartite(graph));
    }
}
