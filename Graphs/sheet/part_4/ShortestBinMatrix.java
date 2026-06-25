package Graphs.sheet.part_4;

import java.util.*;

public class ShortestBinMatrix {
    class Solution {
        class Pair {
            int x, y;
            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length; int m = grid[0].length;

            if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;

            int[][] dist = new int[n][m];

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    dist[i][j] = -1;
                }
            }

            Queue<Pair> q = new ArrayDeque<>(); 
            q.offer(new Pair(0, 0));
            dist[0][0] = 1;

            int[] drows = {1, 0, -1, 0, 1, -1, -1, 1};
            int[] dcols = {0, -1, 0, 1, 1, -1, 1, -1};

            while(!q.isEmpty()) {
                Pair curr = q.poll();
                int x = curr.x;
                int y = curr.y;
                int d = dist[x][y];
                
                for(int k=0; k<8; k++) {
                    int dx = x + drows[k];
                    int dy = y + dcols[k];

                    if((dx>=0 && dy>=0 && dx<n && dy<m) && grid[dx][dy] == 0 && dist[dx][dy] == -1) {
                        dist[dx][dy] = d+1;
                        q.offer(new Pair(dx, dy));
                    }
                }
            }   

            return dist[n-1][m-1];
        }
    }
}
