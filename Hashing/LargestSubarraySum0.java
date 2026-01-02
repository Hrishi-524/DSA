package Hashing;

import java.util.HashMap;

public class LargestSubarraySum0 {
    public static int largestSubarrayWithSumZero(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int len=0;

        for(int j=0; j<nums.length; j++) {
            sum += nums[j];
            if(map.containsKey(sum)) {
                int i=map.get(sum);
                len = Math.max(len, j-i);
            } else {
                map.put(sum, j);
            }
        }

        return len;
    }
    public static void main(String[] args) {
        int[] nums= {15, -2, 2, -8, 1, 7, 10, 23};

        System.out.println("Largest subarray with sum as 0 = "+largestSubarrayWithSumZero(nums));
    }
}
