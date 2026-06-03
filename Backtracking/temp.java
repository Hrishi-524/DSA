package Backtracking;

public class temp {

    public static boolean knightsTour(int[][] board, int x, int y, int move) {
        int n = board.length;

        // base case: if move number exceeds total cells
        if (move == n * n) {
            printBoard(board);
            return true; // or continue recursion to find all solutions
        }

        // boundaries and visited check
        if (x < 0 || y < 0 || x >= n || y >= n || board[x][y] != -1) {
            return false;
        }

        board[x][y] = move; // mark current move

        // all 8 possible knight moves
        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        // try all next moves
        for (int i = 0; i < 8; i++) {
            if (knightsTour(board, x + dx[i], y + dy[i], move + 1)) {
                return true; // return here to stop after 1 solution
            }
        }

        // backtrack
        board[x][y] = -1;
        return false;
    }

    public static void printBoard(int[][] board) {
        System.out.println("Knight's tour solution:");
        for (int[] row : board) {
            for (int val : row) {
                System.out.printf("%2d ", val);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8; // Use 5 for reasonable runtime. 8x8 takes a long time without heuristics.
        int[][] board = new int[n][n];

        // initialize the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = -1;
            }
        }

        // Start from top-left corner
        boolean success = knightsTour(board, 0, 0, 0);
        if (!success) {
            System.out.println("No solution found.");
        }
    }
}
