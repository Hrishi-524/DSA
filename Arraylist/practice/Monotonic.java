package Arraylist.practice;
import java.util.*;

public class Monotonic {

    public static boolean isIncreasing(ArrayList<Integer> nums) {   
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i) > nums.get(i+1)) return false;
        }
        return true;
    }

    public static boolean isDecreasing(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i) < nums.get(i+1)) return false;
        }
        return true;
    }

    public static boolean isMonotonic(ArrayList<Integer> nums) {
        return isIncreasing(nums) || isDecreasing(nums);
    }
    
    public static void main(String[] args) {
        
    }
}
