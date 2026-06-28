package Graphs.sheet.part_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    class Solution {
        class Edge {
            int src, dest, wt;
            Edge(int src, int dest, int wt) {
                this.src = src;
                this.dest = dest;
                this.wt = wt;
            }
        }

        class Pair implements Comparable<Pair> {
            int node, delay;
            Pair(int node, int delay) {
                this.node = node;
                this.delay = delay;
            }

            @Override
            public int compareTo(Pair other) {
                return Integer.compare(this.delay, other.delay);
            }
        }

        @SuppressWarnings("unchecked")
        public int networkDelayTime(int[][] times, int n, int k) {
            ArrayList<Edge>[] graph = new ArrayList[n];

            for(int i=0; i<n; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<times.length; i++) {
                int u = times[i][0]-1;
                int v = times[i][1]-1;
                int w = times[i][2];

                graph[u].add(new Edge(u, v, w));
            }

            int[] delay = new int[n];
            Arrays.fill(delay, Integer.MAX_VALUE);
            
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.offer(new Pair(k-1, 0));
            delay[k-1] = 0;

            while(!pq.isEmpty()) {
                Pair curr = pq.poll();

                for(Edge e : graph[curr.node]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(delay[u] + wt < delay[v]) {
                        delay[v] = delay[u] + wt;
                        pq.offer(new Pair(v, delay[v]));
                    }
                }
            }

            int delayTime = Integer.MIN_VALUE;
            for(int i=0; i<n; i++) {
                if(delay[i] == Integer.MAX_VALUE) {
                    return -1;
                } 
                delayTime = Math.max(delayTime, delay[i]);
            }

            return delayTime;
        }
    }
}