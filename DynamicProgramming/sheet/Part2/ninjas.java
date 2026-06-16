package DynamicProgramming.sheet.Part2;

import java.util.Arrays;

public class ninjas {
    class Memo {
        public int ninjaTraining(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][4];     

            for(int[] row: dp) {
                Arrays.fill(row, -1);
            }
            return f(n-1, 3, matrix, dp);
        }

        int f(int day, int last, int[][] matrix, int[][] dp) {
            if(day < 0) {
                return 0;
            }

            if(dp[day][last] != -1) {
                return dp[day][last];
            }

            int maxi = 0;

            for(int j=0; j<=2; j++) {
                if(j != last) {
                    int points = matrix[day][j] + f(day-1, j, matrix, dp);
                    maxi = Math.max(maxi, points);
                }
            }

            return dp[day][last] = maxi;
        }
    }

    class Solution {
        public int ninjaTraining(int[][] points) {
            int n = points.length;
            // dp[day][last] = max points till 'day' if 'last' activity was done yesterday
            int[][] dp = new int[n][4];

            // Base case: Day 0 initialization
            dp[0][0] = Math.max(points[0][1], points[0][2]); // last = 0 → can't do activity 0 today
            dp[0][1] = Math.max(points[0][0], points[0][2]); // last = 1
            dp[0][2] = Math.max(points[0][0], points[0][1]); // last = 2
            dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2])); // last = 3 (no restriction)

            // Fill DP table
            for (int day = 1; day < n; day++) {
                for (int last = 0; last < 4; last++) {
                    dp[day][last] = 0;
                    for (int task = 0; task < 3; task++) {
                        if (task != last) {
                            int point = points[day][task] + dp[day - 1][task];
                            dp[day][last] = Math.max(dp[day][last], point);
                        }
                    }
                }
            }

            return dp[n - 1][3]; // answer when no restriction on last day
        }
    }
}
