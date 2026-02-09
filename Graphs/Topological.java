package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  Easy explaination : 
 *  "perfrom dfs on graph, while backtracaking add nodes in stack. stack order is topological sort order"
 */

public class Topological {
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

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[3].add(new Edge(3, 1, 1));
        
        graph[2].add(new Edge(2, 3, 1));

        /*
            5 --> 0 <-- 4
            ↓           ↓
            2 --> 3 --> 1
        */
        
        return graph;
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], Stack<Integer> stack) {
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                topologicalSortUtil(graph, curr, visited, stack);
            }
        }

        stack.add(curr);
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) { // Using DFS Method
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i])
                topologicalSortUtil(graph, i, visited, stack);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    public static int[] calcIndeg(ArrayList<Edge>[] graph) { // O(E)
        int[] indeg = new int[graph.length];
        for (int vertex=0; vertex<graph.length; vertex++) { 
            for(Edge e: graph[vertex]) {
                indeg[e.dest]++;
            }
        }
        return indeg;
    }

    public static void kahnsAlgo(ArrayList<Edge>[] graph) { // O(V+E)
        int[] indeg = calcIndeg(graph); // O(E)
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indeg.length; i++) { // O(V)
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");

            for(Edge e : graph[curr]) {
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = createGraph(V);
        kahnsAlgo(graph);
    }
}
