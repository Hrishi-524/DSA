package Graphs;
import java.util.*;

public class KosaRajuAlgo {
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

        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 4, 1));
        
        return graph;
    }

    public static void topoSort(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> stack, int curr) {
        vis[curr] = true;

        for(Edge e : graph[curr]) {
            if(!vis[e.dest])
                topoSort(graph, vis, stack, e.dest);
        }

        stack.push(curr);
    }

    @SuppressWarnings("unchecked")
    public static void kosaRaju(ArrayList<Edge>[] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<V; i++) {
            if(!vis[i])
                topoSort(graph, vis, stack, i);
        }

        ArrayList<Edge>[] transpose = new ArrayList[V];

        for (int i = 0; i < transpose.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for(int i=0; i<graph.length; i++) {
            for(Edge e : graph[i]) {
                transpose[e.dest].add(new Edge(e.dest, e.src, 1));
            }
        }

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if(!vis[curr]) {
                System.out.print("SCC -> ");
                dfs(vis, transpose, curr);
                System.out.println();
            } 
        }
    }

    public static void dfs(boolean[] vis, ArrayList<Edge>[] transpose, int curr) {
        vis[curr] = true;
        System.out.print(curr+" ");

        for(Edge e : transpose[curr]) {
            if(!vis[e.dest]) 
                dfs(vis, transpose, e.dest); 
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = createGraph(V);
        kosaRaju(graph);
    }
}
