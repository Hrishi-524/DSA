package Recursion;

public class Sorted {
    public static boolean isSorted(int nums[], int i) {
        // if(i == nums.length-1 || nums.length == 0) {
        //     return true;
        // }
        
        // boolean currComparison = nums[i] < nums[i+1];
        // boolean prevComparison = isSorted(nums, i+1);

        // return currComparison && prevComparison;
        if(i == nums.length-1) {
            return true;
        }

        if (nums[i] > nums[i+1]) {
            return false;
        }

        return isSorted(nums, i+1);
    }

    public static void main(String[] args) {
        int nums[] = {};
        System.out.println(isSorted(nums, 0));
    }
}
