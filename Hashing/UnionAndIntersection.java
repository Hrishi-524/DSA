package Hashing;

import java.util.HashSet;

public class UnionAndIntersection {

    public static void unionAndIntersection(int[] nums1, int[] nums2) {
        HashSet<Integer> union = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for(int num: nums1) {
            union.add(num);
        }

        for(int num: nums2) {
            if(union.contains(num)) {
                intersection.add(num);
            }
            union.add(num);
        }

        //finally union, intersection are answers
    }
    public static void main(String[] args) {
        
    }
}
