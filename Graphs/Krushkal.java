package Graphs;

import java.util.*;

public class Krushkal {
    static class Edge implements Comparable<Edge> {
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static int n = 4;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static ArrayList<Edge> createGraph() {
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0; i<n; i++) {
            par[i] = i;
        }

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

        return edges;
    }

    public static int find(int x) { // O(4K) ~ O(1)
        if(x == par[x]) {
            return x;
        }

        // assigning par[x] = find(x) is called path compression optimization
        return par[x] = find(par[x]);
    }

    public static void union(int x, int y) { // O(4K) ~ O(1)
        int parX = find(x);
        int parY = find(y);

        if(rank[parX] == rank[parY]) {
            par[parX] = parY;
            rank[parX]++;
        } else if (rank[parX] > rank[parY]) {
            par[parY] = parX;
        } else {
            par[parX] = parY;
        }
    }

    public static int krushkal(ArrayList<Edge> edges, int V) { // O(V + E log E)
        Collections.sort(edges); // O(E log E)
        int minCost = 0;
        int count = 0;

        for (int i=0; count<V-1; i++) { // O(V)
            Edge e = edges.get(i);
            int parX = find(e.src);
            int parY = find(e.dest);
            if(parX != parY) {
                union(e.src, e.dest);
                minCost += e.wt;
                count++;
            } 
        }

        System.out.println("MST cost:"+minCost);

        return minCost;
    }   

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = createGraph();
        krushkal(edges, V);
    }
}
