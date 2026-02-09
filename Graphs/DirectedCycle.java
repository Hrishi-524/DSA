package Graphs;

import java.util.ArrayList;

public class DirectedCycle {
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

    public static boolean hasCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                if(hasCycleUtil(graph, visited, i, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, boolean[] stack) {
        visited[curr] = true;
        stack[curr] = true;

        for(Edge e : graph[curr]) {
            if(stack[e.dest])
                return true;
            else if(!visited[e.dest] && hasCycleUtil(graph, visited, e.dest, stack))
                return true;
        }

        stack[curr] = false;
        return false;
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
        System.out.println(hasCycle(graph));
    }
}
