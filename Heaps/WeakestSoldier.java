package Heaps;

import java.util.PriorityQueue;

public class WeakestSoldier {
    public static class Row implements Comparable<Row> {
        int[] row;
        int soldierCount;
        int index;

        public Row(int soldierCount, int index) {
            this.soldierCount = soldierCount;
            this.index = index;
        }

        @Override
        public int compareTo(Row r2) {
            if(r2.soldierCount == this.soldierCount) 
                return Integer.compare(this.index, r2.index);
            else 
                return Integer.compare(this.soldierCount, r2.soldierCount);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        PriorityQueue<Row> pq = new PriorityQueue<>();
        int k=2;
        
        //O(n*(n + log n)) = O(n^2 + nlogn)
        for(int i=0; i<matrix.length; i++) {//O(n)
            int soldierCount =0;
            for(int j=0; j<matrix[0].length; j++) {//O(n)
                if(matrix[i][j] == 1) soldierCount++;
            }
            Row r = new Row(soldierCount, i);
            pq.add(r);//O(log n)
        }

        for(int i=0; i<k; i++) {
            System.out.println("-"+pq.remove());
        }
    }
}
