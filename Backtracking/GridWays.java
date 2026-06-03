package Backtracking;

public class GridWays {
    public static int gridWays(int n, int m, int i, int j) { // O(2^(m+n))
        //base case
        if(i == n-1 || j == m-1) {
            return 1;
        }
        
        // if you use 
        // if(i == n-1 && j == m-1) {
        //      return 1;
        // }
        // then also incl this
        // if(i == n || j == m) {
        //     return 0;
        // } 

        //kaam
        return gridWays(n, m, i, j+1) + gridWays(n, m, i+1, j);
    }

    public static int factorial(int n) {
        return n == 1 ? 1 : n * factorial(n-1);
    }

    public static int gridWaysOptimised(int n, int m) { // O(n+m)
        return factorial(n+m-2) / (factorial(n) * factorial(m));
    }

    public static void main(String[] args) {
        System.out.println(gridWays(3, 3, 0, 0));
    }
}
