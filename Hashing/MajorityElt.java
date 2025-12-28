package Hashing;

import java.util.HashMap;

public class MajorityElt {
    public static void majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(map.get(nums[i]) > nums.length/3) {
                System.out.println(map.get(nums[i])+" ");
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
