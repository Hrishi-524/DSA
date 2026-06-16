package Array.assignment1;

public class buyAndSellStock {
    public static int bestProfitBuyAndSellStock(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++) {
            if(buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    /*
    Better Intutive version :-
    Mantra:
    If you're selling on ith day, to have max profit, you buy on min(price[0 ... i-1]) 
    */
    public static int bestProfitBuyAndSellStockAlt(int prices[]) {
        int n = prices.length;
        int minSoFar = prices[0];
        int maxProfit = 0;

        for(int i=1; i<n; i++) {
            int todayProfit = prices[i] - minSoFar;
            maxProfit = Math.max(maxProfit, todayProfit);
            minSoFar = Math.min(minSoFar, prices[i]);
        }

        return maxProfit;
    }

    /*
    State Defination :-
    f(i, buy, cap)
    i = ith day (current day)
    buy = Is buying allowed (If we have buyed earlier, buy = 0 we cant buy, else buy = 1 we can buy)
    cap = Amount of transcations allowed (A transcation is buy-sell pair)

    In any DP on stocks problem you're allowed to hold only one stock at a time

    Stocks I :-
    f(i, buy, cap=1) 
        if cap == 0:
            return maxProfit
        if i == n:
            sell on last day means todayProfit = price[n-1] - buyPrice
            return maxProfit = max(todayProfit, maxProfit)
        
        if buy == 0: // you can sell
            choose to sell = f(i+1, buy=1, cap=1) and cap-- and todayProfit = price[i] - buyPrice, maxProfit = max(todayProfit, maxProfit)
            choose to not sell = f(i+1, buy=0, cap=1)

            return max(sell, not sell)
        else: // you haven't buyed yet
            choose to buy today = f(i+1, buy=0, cap=1) and buyPrice = price[i]
            choose not to buy today = f(i+1. buy=1, cap=1)

            return max(buy, not buy)
        
        // now later when I think more purely base case must be:
        // Old base case is mostly wrong
        // if cap == 0 or i == n:
        //     return maxProfit

        // more thought suggest alternate approach of making buy variable itself representing buyPrice, with -1 being you havent buyed yet
        // therefore buy == -1 (you can buy) and buy != -1 (you can sell)
    */  

    /*
    State defination :-
    f(i, buy, cap)
    i = ith day (current day)
    buy = Is buying allowed (If we have buyed earlier, buy = 0 we cant buy, else buy = 1 we can buy)
    cap = Amount of transcations allowed (A transcation is buy-sell pair)

    "Maximum future profit achievable from here"

    Base cases:
    if cap == 0: // we sold - no future profit
        return 0
    if i == n: // days exhausted - noting for profit
        return 0

    if buy == 1:
        // buy 
        -prices[i] + f(i+1, 0, 1)
        // not buy
        f(i+1, 1, 1)
        reuturn max(buy, not-buy)

    if buy == 0:
        // sell
        prices[i] + f(i+1, 1, 0)
        // not sell
        f(i+1, 0, 1)
        return max(sell, not-sell)

    */
    public static int bss(int i, int buy, int cap, int prices[]) {
        if(cap == 0 || i == prices.length) {
            return 0;
        }

        if(buy == 1) {
            return Math.max(
                -prices[i] + bss(i+1, 0, cap, prices),
                bss(i+1, 1, cap, prices)
            );
        } else {
            return Math.max(
                prices[i] + bss(i+1, 1, cap-1, prices),
                bss(i+1, 0, cap, prices)
            );
        }
    }

    /*
    Buy and Sell II :-

    f(i, buy) = "Maximum future profit available from here"

    Base cases:
    if i == n:
        return 0

    if buy == 1:
        // buy
        -prices[i] + f(i+1, 0)
        // not buy
        f(i+1, 1)

        return max(buy, notBuy)

    if buy == 0:
        // sell
        prices[i] + f(i+1, 1)
        // not sell
        f(i+1, 0)

        return max(sell, notSell)
    */

    class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3]; // [day][buy/sell][cap]

        for(int j=0; j<=1; j++) {
            for(int k=0; k<=2; k++) {
                dp[n][j][k] = 0;
            }
        }

        for(int i=0; i<=n; i++) {
            dp[i][0][0] = 0;
            dp[i][1][0] = 0;
        }

        for(int i=n-1; i>=0; i--) {
            for(int k=1; k<=2; k++) {
                dp[i][1][k] = Math.max(
                    -prices[i] + dp[i+1][0][k],
                    dp[i+1][1][k]
                );

                dp[i][0][k] = Math.max(
                    prices[i] + dp[i+1][1][k-1],
                    dp[i+1][0][k]
                );
            }
        }

        return dp[0][1][2];
    }

    public static int helper(int i, int buy, int cap, int[] prices, int[][][] dp) {
        if (cap == 0 || i == prices.length) return 0;

        if (dp[i][buy][cap] != -1) return dp[i][buy][cap];

        if (buy == 1) {
            return dp[i][buy][cap] = Math.max(
                -prices[i] + helper(i+1, 0, cap, prices, dp), // buy
                helper(i+1, 1, cap, prices, dp)               // skip
            );
        } else {
            return dp[i][buy][cap] = Math.max(
                prices[i] + helper(i+1, 1, cap-1, prices, dp), // sell
                helper(i+1, 0, cap, prices, dp)                // skip
            );
        }
    }
}

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(bestProfitBuyAndSellStockAlt(prices));
        // System.out.println(bss(0, -1, 1, prices, 0));
    }
}
