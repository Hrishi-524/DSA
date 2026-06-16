package DynamicProgramming;

import java.util.Arrays;

public class MCM {
    /*
        MCM - Matrix Chain Multiplication
        State the problem:
        f(i, j) = minimum number of multiplications needed to multiply the matrices from index i to j

        A1 x A2 x A3 ... x Ak x Ak+1 x     ...    x An
        |-------------------|    |-------------------|
        i                   k    k+1                 j
        \ ----- f(i, k) --- /    \ --- f(k+1, j) --- /

        cost 1 = f(i, k)
        cost 2 = f(k+1, j)
        cost 3 = arr[i-1] * arr[k] * arr[j]

        since, Ai = arr[i-1] x arr[i] and Ak = arr[k-1] x arr[k] and Aj = arr[j-1] x arr[j]
        therefore, cost 3 = arr[i-1] * arr[k] * arr[j]

        currentCost = cost 1 + cost 2 + cost 3
        minCost = min(minCost, currentCost)

        Base case: if i >= j, return 0

        when i == j there is only one matrix, so no multiplication is needed, hence cost is 0
        when i > j, it is an invalid case, so we can also return 0
    */
    public static int mcm(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = mcm(arr, i, k) + mcm(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, steps);
        }
        return min;
    }

    /*
        State Defination:
        dp[i][j] = minimum number of multiplications needed to multiply the matrices from index i to j
        dp[n][n]
    */
    public static int mcmMemo(int[] arr, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = mcmMemo(arr, i, k, dp) + mcmMemo(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, steps);
        }
        return dp[i][j] = min;
    }

    public static int mcmTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // init
        // for(int i=0; i<n; i++) {
        //     dp[i][i] = 0;
        // }


        for(int len=2; len<n; len++) {
            for(int i=1; i<n-len; i++) {
                int j = i+len-1;
                // here i = row, j = col in dp for diagnoal traversal
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(cost1, Math.min(cost2, cost3));
                }   
            }
        }

        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        int n = arr.length;
        int[][] dp = new int[n][n];
        Arrays.fill(dp, -1);
        System.out.println(mcm(arr, 1, n - 1));
        System.out.println(mcmMemo(arr, 1, n - 1, dp));
    }
}
