package Array.dsa_sheet;

import java.util.Arrays;

public class majorityElement {
    /**
     * METHOD 1 = If element appears more than floor(n/2) times
     * then it should always occupy the middle index of array 
     * when its sorted
     */
    public int majorityElement_op(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }

    /**
     * Approach 2: Hash Map
     * Intuition:
     * The intuition behind using a hash map is to count the occurrences of each element in the array and
     * then identify the element that occurs more than n/2 times. By storing the counts in a hash map, we
     * can efficiently keep track of the occurrences of each element.
     */


     /**
      * Approach 3: Moore Voting Algorithm
      * The intuition behind the Moore's Voting Algorithm is based on the fact that if there is a majority
      * element in an array, it will always remain in the lead, even after encountering other elements.
      */

    public int majorityElementM(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
    public static void main(String[] args) {
        
    }
}
