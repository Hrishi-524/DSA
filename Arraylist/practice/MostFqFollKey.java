package Arraylist.practice;

import java.util.ArrayList;

public class MostFqFollKey {
    public static int mostFreqFollKey(ArrayList<Integer> nums, int key) {
        int n = nums.size();
        ArrayList<Integer> targets = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(nums.get(i) == key) {
                appendTarget(nums, i, targets, counts);
            }
        }

        return returnMaxCountTarget(targets, counts);
    }

    public static void appendTarget(ArrayList<Integer> nums, int idx, ArrayList<Integer> targets, ArrayList<Integer> counts) {
        int n = nums.size();
        if(idx+1 == n) return;

        int target = nums.get(idx+1);

        for(int i=0; i<targets.size(); i++) {
            if(targets.get(i) == target) {
                counts.set(i, counts.get(i)+1);
                return;
            }
        }

        targets.add(target);
        counts.add(1);
        return;
    }

    public static int returnMaxCountTarget(ArrayList<Integer> targets,ArrayList<Integer> counts) {
        int maxCount = Integer.MIN_VALUE;
        int idx=0;

        for(int i=0; i<counts.size(); i++) {
            int count = counts.get(i);
            if(maxCount < count) {
                maxCount = count;
                idx = i;
            }
        }

        return targets.get(idx);
    }

    public static void main(String[] args) {
        
    }
}
