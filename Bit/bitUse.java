package Bit;

public class bitUse {
    public static boolean isPowerOf2(int n) {
        // if n is power of 2 (2^k) => 10000 .. so on 
        // and then n-1 is 2^k -1   => 01111 .. so on 
        //                           & ----- .. so on
        // using & operator we get  => 00000 .. so on
        return (n & (n-1)) == 0;
    }
    public static void main(String[] args) {
        
    }
}
