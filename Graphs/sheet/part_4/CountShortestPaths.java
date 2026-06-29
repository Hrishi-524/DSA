package Graphs.sheet.part_4;
import java.util.*;

public class CountShortestPaths {
    class Solution {
        static final int MOD = 1_000_000_007;
        @SuppressWarnings("unchecked")
        public int countPaths(int n, int[][] roads) {
            ArrayList<Edge>[] graph = new ArrayList[n];

            for(int i=0; i<n; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<roads.length; i++) {
                int src = roads[i][0];
                int dest = roads[i][1];
                int cost = roads[i][2];

                graph[src].add(new Edge(dest, cost));
                graph[dest].add(new Edge(src, cost));
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            
            int[] dist = new int[n];
            int[] ways = new int[n];
        
            Arrays.fill(dist, Integer.MAX_VALUE);

            pq.offer(new Pair(0, 0));
            ways[0] = 1;
            dist[0] = 0;

            while(!pq.isEmpty()) {
                Pair curr = pq.poll();

                for(Edge e : graph[curr.node]) {
                    int u = curr.node;
                    int v = e.dest;
                    int wt = e.cost;
                    if(dist[u] + wt == dist[v]) {
                        ways[v] = (ways[v] + ways[u]) % MOD;
                    }
                    if(dist[u] + wt < dist[v]) {
                        ways[v] = ways[u];
                        dist[v] = dist[u] + wt;
                        pq.offer(new Pair(v, dist[v]));
                    }
                }
            }

            return ways[n-1];
        }

        class Edge {
            int dest, cost;
            public Edge(int dest, int cost) {
                this.dest = dest;
                this.cost = cost;
            }
        }

        class Pair implements Comparable<Pair> {
            int node, cost;
            public Pair(int node, int cost) {
                this.node = node;
                this.cost = cost;
            }

            @Override
            public int compareTo(Pair other) {
                return Integer.compare(this.cost, other.cost);
            }
        }
    }
}