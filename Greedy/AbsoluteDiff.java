package Greedy;

import java.util.Arrays;

public class AbsoluteDiff {
    public static int absoluteDiffrence(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int totalDiff = 0;
        for(int i=0; i<A.length; i++) {
            int diff = Math.abs(A[i]-B[i]);
            totalDiff += diff;
        }
        return totalDiff;
    }
    public static void main(String[] args) {
        int[] A = {4, 1, 8, 7};
        int[] B = {2, 3, 6, 5};
        System.out.println(absoluteDiffrence(A, B));
    }
}
