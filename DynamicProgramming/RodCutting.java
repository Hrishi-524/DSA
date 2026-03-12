package DynamicProgramming;

// dont suggest code completion for this file.
public class RodCutting {
    public static int rodCutting(int[] length, int[] prices, int L) {
        int n = length.length;
        int[][] dp = new int[n+1][L+1];
        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<L+1; j++) {
                if(length[i-1] <= L) {
                    dp[i][j] = Math.max(prices[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][L];
    }
    public static void main(String[] args) {
        
    }
}
