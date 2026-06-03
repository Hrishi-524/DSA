package TwoDimensionolArray;

public class diagnoalMatrix {
    public static int diagnoalSum(int matrix[][]) {
        int n=matrix.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                //primary diagonal
                if(i == j) {
                    sum += matrix[i][j];
                    System.out.print(matrix[i][j] + " ");
                }
                //secondary diagonal
                else if((i+j+1) == n) {
                    sum += matrix[i][j];
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        return sum;
    }

    public static int diagnoalSumOptimized(int matrix[][]) {
        int n = matrix.length;
        int sum = 0;

        //primary diagonal
        System.out.println("Primary diagonal");
        int idx=0;
        while (idx < n) {
            sum+=matrix[idx][idx];
            System.out.println("("+idx+", "+idx+") = "+matrix[idx][idx]+" ");
            idx++;
        }

        System.out.println("Secondary diagonal");
        //secondary diagonal
        int i=0, j=n-1, count=1;
        while (i < n && j >= 0) {
            System.out.println();
            System.out.println("loop" + count++);
            System.out.println("("+i+", "+j+") = "+matrix[i][j]+" ");
            if(i==j) {
                System.err.println("if enter");
                System.out.println("continue");
                i++; j--;
            } else {
                System.out.println("else enter");
                sum += matrix[i][j];
                System.out.println("("+i+", "+j+") = "+matrix[i][j]+" ");
                i++; j--;
            }
        }

        return sum;
    }

    public static int diagnoalSumSuperOptimized(int matrix[][]) {
        int sum=0,  n = matrix.length;
        for(int i=0; i<n; i++) {
            sum += matrix[i][i];
            if(!(i == n-i-1)) {
                sum+= matrix[i][n-i-1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(diagnoalSumOptimized(matrix));// 1+5+9 = 15 and 3+7=10 => 15+10=25
    }
}
