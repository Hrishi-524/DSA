package Graphs.sheet.part_2;

import java.util.ArrayList;

public class CourseSchedule {
    class Solution {
    static class Edge {
        int src, dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    
    @SuppressWarnings("unchecked")
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(new Edge(u, v));
        }

        boolean[] vis = new boolean[V];
        boolean[] stack = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                if(hasCycle(i, graph, vis, stack)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean hasCycle(int curr, ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for(Edge e : graph[curr]) {
            if(stack[e.dest]) {
                return true;
            }
            else if(!vis[e.dest] && hasCycle(e.dest, graph, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;

        return false;
    }
}
}
