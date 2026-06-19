package Graphs.sheet.part_2;
import java.util.*;

public class NumeberOfIslands {
    class Solution {
    class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) { // TC=O(m x n) SC=O(m x n)
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int islands = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j] && grid[i][j]=='1') {
                    islands++;
                    bfsUtil(i, j, vis, grid);
                }
            }
        } 

        return islands;
    }

    void bfsUtil(int i, int j, boolean[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pos> q = new LinkedList<>();

        q.add(new Pos(i, j));

        int[] drows = {-1, 0, 1, 0};
        int[] dcols = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pos curr = q.remove();

            for(int k=0; k<4; k++) {
                int x = curr.x + drows[k];
                int y = curr.y + dcols[k];

                if((x>=0 && x<n && y>=0 && y<m) && !vis[x][y] && grid[x][y]=='1') {
                    q.add(new Pos(x, y));
                    vis[x][y] = true;
                }
            }
        }
    }
}
}
