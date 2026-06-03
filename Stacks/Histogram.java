package Stacks;

import java.util.Stack;

public class Histogram {
    /* 
     * O(3n) => Overall ~ O(n) [linear time complexity]
     * O(3n) => Overall ~ O(n) [linear space complexity]
     */
    public static int maxAreaInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        /* first we will calculate nextSmaller right and left arrays */
        int[] nsr = new int[n];
        int[] nsl = new int[n];

        /* nsr - loop backwards and pop from stack until you find smaller */
        for(int i=n-1; i>=0; i--) {
            /* remove or pop elements from stack until you find the smaller one */ 
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            /* 
                once you find the smaller one - this is the nextSmaller elements, 
                if stack is empty then no next smaller exists 
            */
            if(stack.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = stack.peek();
            }

            /* finally push current element index in stack */
            stack.push(i);
        }

        /* Empty the stack before moving ahead */
        stack.clear();

        /* nsl - loop forwards and pop from stack until you find smaller */
        for(int i=0; i<n; i++) {
            /* internal will remain same as nsr as we are still finding smaller */
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nsl[i] = n;
            } else {
                nsl[i] = stack.peek();
            }
            /* finally push current element index in stack */
            stack.push(i);
        }

        /* loop over the heights array now to find the area delclare maxArea and area*/
        int area = 0, maxArea = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            /* area = height * width
             * so for width = 
             * (diatance of smaller element towards right-1[bec we want just before smaller one]) - 
             * (distance of smaller element towards left+1[bec we want just after smaller one]) 
             * + 1(for zero based indexing)
             */
            area = heights[i] * (nsr[i] - nsl[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights ={2, 1, 5, 6, 2, 3};
        System.out.println(maxAreaInHistogram(heights));

    }
}
