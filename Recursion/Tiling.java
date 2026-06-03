package Recursion;

public class Tiling {
    /**
     * Given a "2 x n" board/floor and tiles of size '2 x 1', 
     * count the number of ways to tile the given board or floor using '2 x 1' tiles 
     * (A tile can be placed either horizontally or vertically)
     */
    public static int tiling(int n) {
        if(n == 2) {
            return 2;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        return tiling(n-1) + tiling(n-2);
    }

    /**
     * Given a "m x n" board/floor and tiles of size 'm x 1', 
     * count the number of ways to tile the given board or floor using '2 x 1' tiles 
     * (A tile can be placed either horizontally or vertically)
     */
    public static int tilingGenral(int m, int n) {
        if(n == m) {
            return 2;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        return tiling(n-1) + tiling(n-m);
    }
    public static void main(String[] args) {
        
    }
}
