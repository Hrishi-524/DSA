package DynamicProgramming;

import java.util.Arrays;

public class UniquePaths {
    class Recursion {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m+1][n+1];
            for(int[] row : dp) Arrays.fill(row, -1);

            return uniquePathsUtil(m, n, dp);
        }

        int uniquePathsUtil(int m, int n, int[][] dp) {
            if(m == 1 || n == 1) {
                dp[m][n] = 1;
                return 1;
            }

            if(dp[m][n] != -1) {
                return dp[m][n];
            }

            dp[m][n] = uniquePathsUtil(m-1, n, dp) + uniquePathsUtil(m, n-1, dp);

            return dp[m][n];
        }
    }

    
    public static void main(String[] args) {
        
    }
}