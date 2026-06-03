package Backtracking;

public class RatMaze {
    public static void ratMaze(int maze[][], int ans[][], int i, int j, char prevMove) {
        int n = maze.length;
        //base case
        if( i < 0 || j < 0 || i >= n || j >= n) return;

        if(i==n-1 && j==n-1) {
            ans[i][j] = 1;
            printMaze(ans);
            ans[i][j] = 0;
            return;
        }
        
        //kaam
        if(maze[i][j] == 0) return;

        if(ans[i][j] == 1) return;

        ans[i][j] = 1;
        
        if(prevMove != 'L') ratMaze(maze, ans, i, j+1, 'R');
        if(prevMove != 'R') ratMaze(maze, ans, i, j-1, 'L');
        if(prevMove != 'D') ratMaze(maze, ans, i-1, j, 'U');    
        if(prevMove != 'U') ratMaze(maze, ans, i+1, j, 'D');

        ans[i][j] = 0;
    }

    public static void printMaze(int ans[][]) {
        System.out.println("-- maze --");
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<ans.length; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[][] maze = {
        //     {1, 1},
        //     {0, 1}
        // };
        int maze[][] = { { 1, 0, 0, 0 },{ 1, 1, 0, 1 },{ 0, 1, 0, 0 },{ 1, 1, 1, 1 } };
        int n = maze.length;
        int[][] ans = new int[n][n];

        ratMaze(maze, ans, 0, 0, 'N');
    }
}
