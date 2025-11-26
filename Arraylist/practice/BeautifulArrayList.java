package Arraylist.practice;

import java.util.ArrayList;

public class BeautifulArrayList {

    public static void genBeautifulArrayList(int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0; i<n; i++) {
            nums.add(i+1);
        }
        
        helper(nums, 0, n-1);
        for(int i=0; i<n; i++) {
            System.out.print(nums.get(i)+" ");
        }
        System.out.println();
    }

    public static void helper(ArrayList<Integer> nums, int si, int ei) {
        //base case
        if( si >= ei) return;

        if(si == ei-1) return;

        //recursion
        int mid = si+(ei-si)/2;

        if(2*nums.get(mid)==nums.get(si)+nums.get(ei)) {
            if(nums.get(si) < nums.get(ei)) {
                int temp = nums.get(mid);
                nums.set(mid, nums.get(si));
                nums.set(si, temp);
            } else {
                int temp = nums.get(mid);
                nums.set(mid, nums.get(ei));
                nums.set(ei, temp);
            }
        }

        helper(nums, si, mid);
        helper(nums, mid+1, ei);
    }
    public static void main(String[] args) {
        genBeautifulArrayList(4);
    }
}
