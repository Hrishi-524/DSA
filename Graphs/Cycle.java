package Graphs;

import java.util.ArrayList;

public class Cycle {
    public static class Edge {
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

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

        return graph;
    }

    public static boolean hasCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i <  graph.length; i++) {
            if(!visited[i])
                if(hasCycleUtil(graph, visited, i, -1)) {
                    return true;
                }
        }

        return false;
    }
    public static boolean hasCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int par) {
        visited[curr] = true;
        for(Edge e : graph[curr]) {
            if(!visited[e.dest] && hasCycleUtil(graph, visited, e.dest, curr)) {
                return true;
            } 
            else if(visited[e.dest] && e.dest != par) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /*    
              1 --- 3 
             /      | \
            0       |  5 
             \      | / \
              2 --- 4    6
        */ 

        int V=7;
        ArrayList<Edge>[] graph = createGraph(V);

        System.out.println(hasCycle(graph));
    }
}
