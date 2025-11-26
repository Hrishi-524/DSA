package Arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairSum1 {
    public static boolean pairSum1(ArrayList<Integer> nums, int target) {
        int lp = 0, rp = nums.size()-1;
        while (lp < rp) {
            if (nums.get(lp) + nums.get(rp) == target) {
                return true;
            }

            if(nums.get(lp) + nums.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(1, 4, 5, 2, 3, 6, 8, 7));
        int target = 9;
        Collections.sort(nums);
        System.out.println(pairSum1(nums, target));
    }
}
