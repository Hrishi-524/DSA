package Graphs.sheet.part_4;

import java.util.*;

public class MinMulToReachEnd {
    class Solution {
        class Pair {
            int num, steps;
            Pair(int num, int steps) {
                this.num = num;
                this.steps = steps;
            }
        }
        public int minimumMultiplications(int[] arr, int start, int end) {
            Queue<Pair> q = new ArrayDeque<>();
            q.offer(new Pair(start, 0));

            int[] dist = new int[99999];
            Arrays.fill(dist, Integer.MAX_VALUE);
            int MOD = 100000;

            while(!q.isEmpty()) {
                Pair curr = q.poll();
                int num = curr.num;
                int steps = curr.steps;

                for(int i=0; i<arr.length; i++) {
                    int nb = (num * arr[i]) % MOD;
                    if(steps + 1 < dist[nb]) {
                        dist[nb] = steps + 1;
                        if(nb == end) return steps + 1;
                        q.offer(new Pair(nb, steps+1));
                    }
                }
            }
            return -1;
        }
    }
}
