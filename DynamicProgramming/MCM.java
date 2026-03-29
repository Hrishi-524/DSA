package DynamicProgramming;

import java.util.Arrays;

public class MCM {
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        int n = arr.length;
        int[][] dp = new int[n][n];
        Arrays.fill(dp, -1);
        System.out.println(mcm(arr, 1, n - 1));
        System.out.println(mcmMemo(arr, 1, n - 1, dp));
    }
}
