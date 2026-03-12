package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;

public class LIS {
    public static int lcs(int[] nums1, int[] nums2) {
        int n = nums1.length; 
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static int LISeq(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int[] sorted = new int[set.size()];
        int i = 0;
        for(int num : set) {
            sorted[i++] = num;
        }

        Arrays.sort(sorted);
        
        return lcs(nums, sorted);
    }
    
    public static void main(String[] args) {
        
    }
}
