package Hashing;

import java.util.HashSet;

public class CountDistinct {

    public static int countDistinctElements(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(int num : nums) {
            hs.add(num);
        }

        return hs.size();
    }
    public static void main(String[] args) {
        
    }
}