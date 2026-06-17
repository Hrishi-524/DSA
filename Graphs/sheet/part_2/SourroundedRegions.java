package Graphs.sheet.part_2;

import java.util.*; 

public class SourroundedRegions {
    class Solution {
    class Pair {
        int i, j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        // multi-source bfs from all the 'O' that lies on the edges
        // They will mark all the edge included regions True, rest will stay False
        // convert all the 'O' -> 'X' which have False, because it means they arent included in edge regions
        Queue<Pair> q = new ArrayDeque<>();

        boolean[][] vis = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'O' && (i == 0 || i == n-1 || j == 0 || j == m-1)) {
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

                if(x >=0 && x <n && y >=0 && y <m && !vis[x][y] && board[x][y] == 'O') {
                    q.add(new Pair(x, y));
                    vis[x][y] = true;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
}
