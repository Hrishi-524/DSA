package Array;

public class trappedRW {
    public static int trappedRainWater(int height[]) {
        //create auxillary arrays => leftMaxBoundry and rightMaxBoundry
        int leftMaxBoundry[] = new int[height.length];
        int rightMaxBoundry[] = new int[height.length];

        for(int i=0; i<height.length; i++) {
            if(i==0) {
                leftMaxBoundry[i] = height[i];
            } else {
                // if(height[i] > leftMaxBoundry[i-1]) {
                //     leftMaxBoundry[i] = height[i];
                // } else {
                //     leftMaxBoundry[i] = leftMaxBoundry[i-1];
                // }
                leftMaxBoundry[i] = height[i] > leftMaxBoundry[i-1] ? height[i] : leftMaxBoundry[i-1];
            }
        }

        for(int i=height.length-1; i>=0; i--) {
            if(i==height.length-1) {
                rightMaxBoundry[height.length-1] = height[height.length-1];
            } else {
                rightMaxBoundry[i] = height[i] > rightMaxBoundry[i+1] ? height[i] : rightMaxBoundry[i+1];
            }
        }

        int totalTrappedWater = 0;

        for(int i=0; i<height.length; i++) {
            int waterLevel = Math.min(leftMaxBoundry[i], rightMaxBoundry[i]);
            int trappedWater = waterLevel - height[i];
            totalTrappedWater += trappedWater;
        }
        System.out.println(totalTrappedWater);
        return totalTrappedWater;
    }

    public static void main(String[] args) {
        // int height[] = {4, 2, 0, 6, 3, 2, 5};
        int height[] = {1, 2, 3, 4, 5, 6, 7};
        trappedRainWater(height);
    }
}