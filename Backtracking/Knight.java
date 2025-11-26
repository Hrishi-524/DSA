package Backtracking;

public class Knight {

    public static boolean knightsTour(int board[][], int x, int y, int count) {
        int n = board.length;
        //base case
        if(count == (n*n)) {
            printBoard(board);
            return true;
        }
        
        if(x < 0 || y < 0 || x >= n || y >= n || board[x][y] != -1) {
            return false;
        }
        //work

        //visit by putting appropriate count at current (x, y)
        board[x][y] = count;

        //explore all the moves of knight
        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        for(int i=0; i<n; i++) {
            if(knightsTour(board, x+dx[i], y+dy[i], count+1)) {
                return true;
            }
        }
        
        //derease count and unvisit while comming back if no moves possible
        board[x][y] = -1;
    
        return false;
    }

    public static void printBoard(int board[][]) {
        int n=board.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int board[][] = new int[n][n];

        //initialization - mark all unvisited by using -1
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = -1;
            }
        }

        knightsTour(board, 0, 0, 0);
    }
}
