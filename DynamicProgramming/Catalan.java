package DynamicProgramming;

public class Catalan {
    public static int catalanRec(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += catalanrec(i) * catalanrec(n-i-1);
        }

        return ans;
    }

    public static int catalanMemo(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            dp[i] = catalanMemo(i, dp);
            dp[n-i-1] = catalanMemo(n-i-1, dp);
            ans += dp[i] * dp[n-i-1];
        }

        return ans;
    }

    public static int catalanTab(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n+1; i++) {
            for(int j=0; j<i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(catalanRec(4));
        System.out.println(catalanMemo(4, new int[5]));
        System.out.println(catalanTab(4));
    }
}
