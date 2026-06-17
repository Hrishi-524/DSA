package Graphs.sheet.part_2;
import java.util.*;

public class NumberOfEncaves {
    class Solution {
        class Pair {
            int i, j;
            Pair(int x, int y) {
                this.i = x;
                this.j = y;
            }
        }
        public int numEnclaves(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            boolean[][] vis = new boolean[n][m];
            Queue<Pair> q = new ArrayDeque<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if((i==0 || j==0 || i==n-1 || j == m-1) && grid[i][j]==1) {
                        q.add(new Pair(i, j));
                        vis[i][j] = true;
                    }
                }
            }

            int[] drows = {-1, 0, 1, 0};
            int[] dcols = {0, -1, 0, 1};

            while(!q.isEmpty()) {
                Pair curr = q.remove();

                for(int k=0; k<4; k++) {
                    int x = curr.i + drows[k];
                    int y = curr.j + dcols[k];

                    if((x>=0 && x<n && y>=0 && y<m) && grid[x][y]==1 && !vis[x][y]) {
                        q.add(new Pair(x, y));
                        vis[x][y] = true;
                    }
                }
            }
            
            int count = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(grid[i][j]==1 && !vis[i][j]) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}