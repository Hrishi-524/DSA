package Recursion;

public class Occurence {
    public static int findFirstOcuurance(int nums[], int key, int i) {
        if(i == nums.length) {
            return -1;
        }

        if(nums[i] == key) {
            return i;
        }

        return findFirstOcuurance(nums, key, i+1);
    }

    public static int findLastOcuurance(int nums[], int key, int i) {
        if(i == -1) {
            return -1;
        }

        if(nums[i] == key) {
            return i;
        }

        return findFirstOcuurance(nums, key, i-1);
    }

    public static int findOccurance(int nums[], int key, String choice) {
        return choice == "last" ? findLastOcuurance(nums, key, nums.length-1) : findFirstOcuurance(nums, key, 0);
    }
    public static void main(String[] args) {
        int nums[] = {10, 7, 27, 34, 25, 16, 33, 25, 66};
        int key = 25;
        // System.out.println(findFirstOcuurance(nums, key, ));
        // System.out.println(findLastOcuurance(nums, key, nums.length-1));
        System.out.println(findOccurance(nums, key, "first"));
        System.out.println(findOccurance(nums, key, "last"));
    }
}
