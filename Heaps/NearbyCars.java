package Heaps;

import java.util.*;

public class NearbyCars {
    public static class Point implements Comparable<Point> {
        int x;
        int y;
        double dist0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist0 = Math.pow(x, 2) + Math.pow(y, 2);
        }

        @Override
        public int compareTo(Point p2) {
            return (int)(this.dist0 - p2.dist0);
        }
    }

    public static void main(String[] args) {
        int[][] pts = {{3, 3}, {5, -1}, {2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0; i<pts.length; i++) {//O(n)
            pq.add(new Point(pts[i][0], pts[i][1]));//O(log n)
        }

        for(int i=0; i<k; i++) {
            System.out.println(pq.remove()+" ");
        }
    }
}
