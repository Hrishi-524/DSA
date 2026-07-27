package Graphs.sheet.leetcode_challange;

import java.util.*;

public class TimeInformEmployees {
    class Solution {
        class Pair {
            int n, c;
            Pair(int n, int c) {
                this.n = n;
                this.c = c;
            }
        }

        @SuppressWarnings("unchecked")
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            if(n == 1) return 0;

            ArrayList<Integer>[] g = new ArrayList[n];
            for(int i=0; i<n; i++) {
                g[i] = new ArrayList<>();
            }

            for(int i=0; i<n; i++) {
                if(manager[i] == -1) continue;
                g[manager[i]].add(i); // mannager -> subordinate
            }

            int[] mins = new int[n];
            boolean[] vis = new boolean[n];
            Queue<Pair> q = new ArrayDeque<>();

            q.offer(new Pair(headID, 0));
            vis[headID] = true;

            while(!q.isEmpty()) {
                Pair curr = q.poll();
                int currNode = curr.n;
                int costSoFar = curr.c;

                for(int nb: g[currNode]) {
                    if(!vis[nb]) {
                        vis[nb] = true;
                        mins[nb] = costSoFar + informTime[currNode];
                        q.offer(new Pair(nb, mins[nb]));
                    }
                }
            }

            int minutesNeeded = 0;
            for(int i=0; i<n; i++) {
                minutesNeeded = Math.max(minutesNeeded, mins[i]);
            }
            return minutesNeeded;
        }   
    }

    class SolutionV2 {
        class Pair {
            int n, c;
            Pair(int n, int c) {
                this.n = n;
                this.c = c;
            }
        }

        @SuppressWarnings("unchecked")
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            if(n == 1) return 0;

            ArrayList<Integer>[] g = new ArrayList[n];
            for(int i=0; i<n; i++) {
                g[i] = new ArrayList<>();
            }

            for(int i=0; i<n; i++) {
                if(manager[i] == -1) continue;
                g[manager[i]].add(i); // mannager -> subordinate
            }

            boolean[] vis = new boolean[n];
            Queue<Pair> q = new ArrayDeque<>();

            q.offer(new Pair(headID, 0));
            vis[headID] = true;
            int minutesNeeded = 0;

            while(!q.isEmpty()) {
                Pair curr = q.poll();
                int currNode = curr.n;
                int costSoFar = curr.c;

                for(int nb: g[currNode]) {
                    if(!vis[nb]) {
                        vis[nb] = true;
                        int nbMinsNeeded = costSoFar + informTime[currNode];
                        minutesNeeded = Math.max(minutesNeeded, nbMinsNeeded);
                        q.offer(new Pair(nb, nbMinsNeeded));
                    }
                }
            }

            return minutesNeeded;
        }   
    }
}
