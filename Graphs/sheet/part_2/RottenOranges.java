package Graphs.sheet.part_2;
import java.util.*;

public class RottenOranges {
    class Solution {
    class Pair {
        int i;
        int j;
        int t;
        Pair(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Add all the rotted oranges into queue first with time t = 0,because they will all simultaneously rot other oranges, therefore they need to go into queue first
        // Queue will always contain rotted oranges with time (i, j, t)
        // Keep the count of fresh oranges as if not all oranges rotted at the end we need to return -1

        // Create a visited array to keep track of state of oranges at any point of time
        boolean[][] vis = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        int totalFresh = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                } else if(grid[i][j] == 1) {
                    totalFresh++;
                }
            }
        }


        // BFS
        /*
            Up = i, j-1
            Down = i, j+1
            Left = i-1, j
            Right = i+1, j
        */

        int tm = 0;
        int[] drows = {0, 0, -1, +1};
        int[] dcols = {-1, +1, 0, 0};
        int cnt = 0;

        while(!q.isEmpty()) {
            Pair curr = q.remove();
            int r = curr.i;
            int c = curr.j;
            int t = curr.t;

            tm = Math.max(tm, t);

            // Add its neighbours into queue with time t+1
            for(int i=0; i<4; i++) {
                int nrow = r + drows[i];
                int ncol = c + dcols[i];

                if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol] = true;
                    cnt++;
                }
            }
        }

        if(totalFresh != cnt) {
            return -1;
        }

        return tm;
    }
}
}