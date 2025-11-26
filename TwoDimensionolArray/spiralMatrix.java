package TwoDimensionolArray;

public class spiralMatrix {
    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;                                                   
        
        while (startRow <= endRow && startCol <= endCol) {
            //top boundry
            for(int j=startCol; j<=endCol; j++) {
                System.out.print(matrix[startRow][j]+" ");
            } 
            //right boundry
            for(int i=startRow+1; i<=endRow; i++) {
                System.out.print(matrix[i][endCol]+" ");
            }
            //bottom boundry
            for(int j=endCol-1; j>=startCol; j--) {
                if(startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            }
            //left boundry
            for(int i=endRow-1; i>=startRow+1; i--) {
                if(startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }
            //update the four varibles to shrink the spiral
            startRow++; 
            endRow--; 
            startCol++; 
            endCol--;
        }
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int matrix2[][] = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20 },
            {21, 22, 23, 24, 25}
        };
        printSpiral(matrix2);
        printSpiral(matrix);
    }
}
