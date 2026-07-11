package Graphs.sheet.part_4;

import java.util.*;

// Cheapest flights with k stops 
public class CheapestFlightsWithKStops {
    class Solution {
        class Edge {
            int s, d, w;
            Edge(int s, int d, int w) {
                this.s = s;
                this.d = d;
                this.w = w;
            }
        }

        class Info {
            int city, cost, stops;
            Info(int city, int cost, int stops) {
                this.city = city;
                this.cost = cost;
                this.stops = stops;
            }
        }

        @SuppressWarnings("unchecked")
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            ArrayList<Edge>[] graph = new ArrayList[n];

            for(int i=0; i<n; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<flights.length; i++) {
                int from = flights[i][0];
                int to = flights[i][1];
                int price = flights[i][2];

                graph[from].add(new Edge(from, to, price));
            }

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            Queue<Info> q = new ArrayDeque<>();
            q.offer(new Info(src, 0, 0));
            dist[src] = 0;

            while(!q.isEmpty()) {
                Info curr = q.poll();
                
                if(curr.stops > k) {
                    break;
                }

                for(Edge e : graph[curr.city]) {
                    if(curr.cost + e.w < dist[e.d] && curr.stops<=k) {
                        dist[e.d] = curr.cost + e.w;
                        q.add(new Info(e.d, dist[e.d], curr.stops+1));
                    }
                }
            }

            if(dist[dst] == Integer.MAX_VALUE) {
                return -1;
            } else {
                return dist[dst];
            }
        }
    }
}