package Graphs;
import java.util.*;

public class Lec1 {
    public static class Edge {
        int src, dest, wt;
        public Edge (int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int V=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0=(5)=1
        graph[0].add(new Edge(0,1, 5));

        // 1=(3)=3 , 1=(1)=2 
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 2, 1));

        // 2=(1)=3 , 2=(2)=4 , 2=(1)=1
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[2].add(new Edge(2, 1, 1));

        // 3=(3)=1 , 3=(1)=2
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
    }
}