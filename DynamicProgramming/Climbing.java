package DynamicProgramming;

public class Climbing {
    public static int climb(int n) { // Recusion : O(2^n)
        if(n == 0) 
            return 1;
        if(n < 0) 
            return 0;
        return climb(n-1) + climb(n-2);
    }

    // Initialize Arrays.fill(dp, -1)
    public static int climbMemo(int n, int[] dp) { // Memoization : O(n)
        if(n == 0) 
            return 1;
        if(n < 0) 
            return 0;

        if(dp[n] != 0) 
            return dp[n];

        dp[n] = climbMemo(n-1, dp) + climbMemo(n-2, dp);

        return dp[n];
    }

    public static int climbTab(int n) { // Tabulation : O(n)
        if(n == 0 || n == 1) 
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + i == 1 ? 0 : dp[i-2];
        }

        return dp[n];
    }

    public static int climbTabVar(int n) { 
        int[] dp = new int[n+1]; 
        dp[0] = 1; 
        for(int i=1; i<=n; i++) dp[i] = dp[i-1] + i == 1 ? 0 : dp[i-2]; 
        return dp[n];
    }
    public static void main(String[] args) {
        
    }
}
