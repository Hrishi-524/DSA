package Array.dsa_sheet;

public class findMissing {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        boolean[] map = new boolean[n*n];
        int[] res = new int[2];

        for(int i=0; i<map.length; i++) {
            map[i] = false;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int val = grid[i][j];
                if(map[val-1]) {
                    res[0] = val;
                } else {
                    map[val-1] = true;
                }
            }
        }

        for(int i=0; i<map.length; i++) {
            if(map[i] == false) {
                res[1] = i+1;
            }
        }
        
        return res;
    }
    /**
     * Approach
        Let's consider the mathematical relationships:

        Let S be the sum of all numbers from 1 to n²
        Let P be the sum of squares of all numbers from 1 to n²
        Let S' be the actual sum of the grid elements
        Let P' be the actual sum of squares of the grid elements
        The differences between these values can help us identify the repeated number a and the missing number b:

        S' - S = a - b (difference between actual sum and expected sum)
        P' - P = a² - b² = (a - b) * (a + b) (difference between actual sum of squares and expected sum of squares)
        Now from these two equations, we can find a and b.
     * 
     */
    class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            int nSquared = n * n;
            
            long expectedSum = (long) nSquared * (nSquared + 1) / 2;
            long expectedSumSquares = (long) nSquared * (nSquared + 1) * (2 * nSquared + 1) / 6;
            
            long actualSum = 0, actualSumSquares = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    actualSum += grid[i][j];
                    actualSumSquares += (long) grid[i][j] * grid[i][j];
                }
            }

            // a - b
            long diffSum = actualSum - expectedSum;

            // a² - b²
            long diffSumSquares = actualSumSquares - expectedSumSquares;
            
            // a + b = (a² - b²) / (a - b)
            long sumAB = diffSumSquares / diffSum;
            
            // Now we can find a and b
            int a = (int) ((sumAB + diffSum) / 2);
            int b = (int) ((sumAB - diffSum) / 2);
            
            return new int[]{a, b};
        }
    }
    public static void main(String[] args) {
        
    }
}
