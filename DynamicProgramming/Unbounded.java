package DynamicProgramming;

public class Unbounded {
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
                int w = values[i-1];

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
        
    }
}
