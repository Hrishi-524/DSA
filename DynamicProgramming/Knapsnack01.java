package DynamicProgramming;
import java.util.Arrays;

public class Knapsnack01 {
    public static int knapsnack(int[] values, int[] weights, int W, int n) {
        if(W == 0 || n == 0) {
            return 0;
        }

        if(weights[n-1] <= W) {
            // Include : W - item.wt & Profit + item.value, then move to next item
            int incl = knapsnack(values, weights, W-weights[n-1], n-1) + values[n-1];

            // Exclude : W, Profit stays same, move to next item
            int excl = knapsnack(values, weights, W, n-1);

            return Math.max(incl, excl);
        } else {
            // Exclude : W, Profit stays same, move to next item
            return knapsnack(values, weights, W, n-1);
        }
    }

    public static int knapsnackMemo(int[] values, int[] weights, int W, int n) { // O(n * W)
        int[][] dp = new int[n+1][W+1];
        Arrays.fill(dp, -1);
        return knapsnackMemoUtil(values, weights, W, n, dp);
    }

    private static int knapsnackMemoUtil(int[] values, int[] weights, int W, int n, int[][] dp) { 
        if(W == 0 || n == 0) {
            return 0;
        }

        if(dp[n][W] != -1) {
            return dp[n][W];
        }

        if(weights[n-1] <= W) {
            // Include : W - item.wt & Profit + item.value, then move to next item
            int incl = knapsnackMemoUtil(values, weights, W-weights[n-1], n-1, dp) + values[n-1];

            // Exclude : W, Profit stays same, move to next item
            int excl = knapsnackMemoUtil(values, weights, W, n-1, dp);

            dp[n][W] = Math.max(incl, excl);
            return dp[n][W];
        } else {
            // Exclude : W, Profit stays same, move to next item
            dp[n][W] = knapsnackMemoUtil(values, weights, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static int knapsnackTab(int[] values, int[] weights, int W, int n) {
        int[][] dp = new int[n+1][W+1];
        
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }

        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = values[i-1];
                int w = values[j-1];

                if(w <= j) {
                    int incl = v + dp[i-1][j-w];
                    int excl = dp[i-1][j-w];
                    dp[i][j] = Math.max(incl, excl);
                } else {
                    dp[i][j] = dp[i-1][j-w];
                }
            }
        }
        
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] values = {15, 14, 10, 45, 30};
        int[] weights = {2, 5, 1, 3, 4};
        int W = 7;
        int n = values.length;
        System.out.println("Maximum profit : "+knapsnack(values, weights, W, n));
    }
}
