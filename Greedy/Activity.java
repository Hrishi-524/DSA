package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Activity {
    public static int activitySelection(int[] start, int[] end) {
        //if end is not sorted - first store the correct indexes and then sort
        int[][] activities = new int[start.length][3];//3 cols => 0th = correct indexes before sorting , 1st = start , 2nd = end
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        //choose A0 as first acivity to do
        System.out.print("A"+activities[0][0]+" ");
        int count =1;
        int lastEnd = activities[0][2];//end[0];
        for(int i=1; i<end.length; i++) {
            //non-overlapping activities
            if( activities[i][1] /* start[i] */ >= lastEnd) {
                System.out.print("A"+activities[i][0]+" ");
                count++;
                lastEnd = activities[i][2]; //end[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 3, 6, 7, 9, 9};

        System.out.println(activitySelection(start, end));
    }
}
