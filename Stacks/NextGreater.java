package Stacks;

import java.util.Stack;

public class NextGreater {
    
    public static int[] nextGreater(int nums[]) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int nextGreaterNums[] = new int[n];

        for(int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nextGreaterNums[i] = -1;
            } else {
                nextGreaterNums[i] = stack.peek();
            }
            stack.push(i);
        }
        return nextGreaterNums;
    }

    public static void printArray(int array[]) {
        System.out.print("[");
        for(int i=0; i<array.length-1; i++) {
            System.out.print(array[i]+", ");
        }
        System.out.print(array[array.length-1]);
        System.out.print("]");
        System.out.println();
    }
    public static void main(String[] args) {
        int nums[] = {1, 0, 3, 8, 5, 6, 9};
        printArray(nextGreater(nums));
    }
}
