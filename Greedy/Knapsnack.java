package Greedy;

import java.util.Arrays;

public class Knapsnack {
    public static double fractionolKnapsnack(int[] profits, int[] weights, int W) {
        double[][] ratios = new double[weights.length][2];
        double maxProfit = 0; 

        for (int i = 0; i < weights.length; i++) { 
            ratios[i][0] = i;
            ratios[i][1] = profits[i] / (double) weights[i];
        }

        Arrays.sort(ratios, (a, b) -> Double.compare(b[1], a[1]));

        for(int i = 0; i < weights.length; i++) {
            int idx = (int) ratios[i][0];
            if(W-weights[idx] >= 0) {
                W = W-weights[idx];
                maxProfit += profits[idx];
            } else {
                double fractionalProfit = ratios[i][1] * W;
                maxProfit += fractionalProfit;
                break;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] profits = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        System.out.println(fractionolKnapsnack(profits, weights, W)); // Should print 240.0
    }
}
