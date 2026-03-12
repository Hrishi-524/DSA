package DynamicProgramming;

import java.util.Arrays;

public class LCS {
    public static int longestCommonSubsequence(String str1, String str2) {
        int[][] dp =new int[str1.length()+1][str2.length()+1];

        Arrays.fill(dp, -1);

        return LCSUtil(str1, str2, str1.length(), str2.length());
    }

    // Recursion Approach
    public static int LCSUtil(String str1, String str2, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(str1.charAt(n) == str2.charAt(m)) {
            return LCSUtil(str1, str2, n-1, m-1);
        } else {
            return Math.max(LCSUtil(str1, str2, n-1, m), LCSUtil(str1, str2, n, m-1));
        }
    }

    public static int LCSUtilMemo(String str1, String str2, int n, int m, int dp[][]) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        if(str1.charAt(n) == str2.charAt(m)) {
            dp[n][m] = LCSUtil(str1, str2, n-1, m-1)+1;
        } else {
            dp[n][m] = Math.max(LCSUtil(str1, str2, n-1, m), LCSUtil(str1, str2, n, m-1));
        }

        return dp[n][m];
    }

    public static int LCSUtilTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
    
    public static void main(String[] args) {
        
    }
}
