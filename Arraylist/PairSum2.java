package Arraylist;

import java.util.ArrayList;
import java.util.List;

public class PairSum2 {
    public static boolean pairSum2(ArrayList<Integer> nums, int tar) {
        int n = nums.size();

        //in case array is not rotated lp and rp will still have correct values
        int lp=0, rp=n-1;

        //find the pivot
        for(int i=0; i<n-1; i++) {
            if(nums.get(i) > nums.get(i+1)) {
                lp = i+1;
                rp = i;
                break;
            }
        }

        //use 2 pointer approach
        while (lp != rp) {
            if(nums.get(lp) + nums.get(rp) == tar) {
                return true;
            }

            if(nums.get(lp) + nums.get(rp) < tar) {
                lp = (lp+1)%n;
            } else {
                rp = (n+rp-1)%n;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(11, 15, 6, 8, 9, 10));
        System.err.println(pairSum2(nums, 18));
    }
}
