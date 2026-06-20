package Graphs.sheet.part_3;

import java.util.*;

public class CourseSchedule2 {
    class Solution {
        static class Edge {
            int src, dest;
            public Edge(int src, int dest) {
                this.src = src;
                this.dest = dest;
            }
        }

        @SuppressWarnings("unchecked")
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int V = numCourses;
            ArrayList<Edge>[] graph = new ArrayList[V];

            for(int i=0; i<V; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int[] edge : prerequisites) {
                int u = edge[0];
                int v = edge[1];

                graph[v].add(new Edge(v, u));
            }

            int[] indeg = calcIndeg(graph);

            Queue<Integer> q = new LinkedList<>();

            int[] courseOrder = new int[V];
            int idx = 0;
            for(int i=0; i<V; i++) {
                if(indeg[i] == 0) {
                    q.add(i);
                    courseOrder[idx++] = i;
                }
            }

            while(!q.isEmpty()) {
                int curr = q.remove();

                for(Edge e : graph[curr]) {
                    indeg[e.dest]--;
                    if(indeg[e.dest] == 0) {
                        q.add(e.dest);
                        courseOrder[idx++] = e.dest;
                    }
                }
            }

            if (idx == V) {
                return courseOrder; // valid ordering
            } else {
                return new int[0]; // cycle detected → no valid order
            }

        }

        int[] calcIndeg(ArrayList<Edge>[] graph) {
            int V = graph.length;
            int[] indeg = new int[V];

            for(int i=0; i<V; i++) {
                for(Edge e : graph[i]) {
                    // src -> dest
                    indeg[e.dest] = indeg[e.dest] + 1;
                }
            }

            return indeg;
        }
    }
}
