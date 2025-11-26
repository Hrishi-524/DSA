package Arraylist;

import java.util.ArrayList;

public class ContainerWithMostWater {
    public static int containerWithMostWater(ArrayList<Integer> heights) {
        int maxArea = 0;
        int lp = 0, rp = heights.size()-1;

        while (lp < rp) {
            //area = height * width
            int height = Math.min(heights.get(lp), heights.get(rp));
            int width = rp - lp;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (heights.get(lp) < heights.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ArrayList<Integer> heights =  new ArrayList<>();
        heights.add(2);
        heights.add(4);
        heights.add(6);
        //complete it
        System.out.println(containerWithMostWater(heights));
    }
}