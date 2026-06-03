package Arraylist.practice;
import java.util.*;

public class Lonely {
    public static ArrayList<Integer> lonelyNumbers(ArrayList<Integer> nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        Collections.sort(nums);
        int n=nums.size();

        for(int i=0; i<n; i++) {
            if(isLonely(nums, i)) {
                ans.add(nums.get(i));
            }
        }

        return ans;
    }

    public static boolean isLonely(ArrayList<Integer> nums, int idx) {
        int n = nums.size();

        //not unique - return false because it is not lonely
        if(idx-1 >= 0 && nums.get(idx-1) == nums.get(idx)) {
            return false;
        }
        if(idx+1 <= n-1 && nums.get(idx+1) == nums.get(idx)) {
            return false;
        }

        //unique - then check if it is lonely
        if(idx-1 >= 0 && nums.get(idx-1) == nums.get(idx)-1) {
            return false;
        }
        if(idx+1 <= n-1 && nums.get(idx+1) == nums.get(idx)+1) {
            return false;
        }

        //if lonely ans unique return true
        return true;
    }
    public static void main(String[] args) {
        
    }
}
