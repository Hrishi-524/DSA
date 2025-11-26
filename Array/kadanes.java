package Array;

public class kadanes {
    public static int kadanes_algo(int nums[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            if ((currSum + nums[i]) < 0) {
                currSum = 0;
            } else {
                currSum += nums[i];
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println(maxSum);
        return maxSum;
    }
    public static void main(String[] args) {
        int nums[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        kadanes_algo(nums);
    }
}
