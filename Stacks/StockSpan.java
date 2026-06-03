package Stacks;
import java.util.*;

public class StockSpan {
    public static int[] stockSpanBF(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // make a result array
        int k=1;// track the index of result array

        span[0] = 1;
        for(int i=1; i<n; i++) { // i : 1 to n-1
            int recentHighIdx = i;
            int todaysPrice = prices[i];
            for(int j=0; j<i; j++) { // j : 0 to i-1 because when j == i it will check with itself(we dont want that)
                if(prices[j] >= todaysPrice) { // we want the most recent greater value
                    recentHighIdx = j;
                }
            }
            int currSpan = i - recentHighIdx;
            span[k++] = currSpan;
        }

        return span;
    }

    public static int[] stockSpanOP(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[n];

        //init
        span[0] = 1;
        stack.push(0);

        for(int i=1; i<n; i++) {
            int currSpan = i - stack.peek();
            span[i] = currSpan;

            while (prices[i] <= prices[stack.peek()] && !stack.isEmpty()) {
                stack.pop();
            }
            
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 85, 100};
        System.out.println(stockSpanOP(prices));
    }
}
