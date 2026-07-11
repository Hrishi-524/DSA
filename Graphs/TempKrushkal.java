package Graphs;

// import java.util.PriorityQueue;

public class TempKrushkal {
//     class Solution {
//     int manhattanDist(Point a, Point b) {
//         return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
//     }

//     class Point {
//         int x, y;
//         Point(int x, int y) {
//             this.x = x;
//             this.y = y;
//         }
//     }

//     class Edge implements Comparable<Edge> {
//         Point src, dest;
//         int wt;
//         Edge(Point src, Point dest, int wt) {
//             this.src = src;
//             this.dest = dest;
//             this.wt = wt;
//         }

//         @Override
//         public int compareTo(Edge e2) {
//             return Integer.compare(this.wt, e2.wt);
//         }
//     }

//     public int minCostConnectPoints(int[][] points) {
//         if(points.length == 1) return 0;
//         int E = points.length;
//         PriorityQueue<Edge> pq = new PriorityQueue<>();

//         for(int i=0; i<E; i++) {
//             for(int j=i; j<E; j++) {
//                 if(j == i) continue;

//                 Point A = new Point(points[i][0], points[i][1]);
//                 Point B = new Point(points[j][0], points[j][1]);
//                 int distAB = manhattanDist(startA, startB);
//                 pq.offer(new Edge(A, B, distAB));
//             }
//         }

//         int minCost = 0;
//         while(!pq.isEmpty()) {
//             Edge e = pq.poll();
//             if(find(e.src) == find(e.dest)) {
//                 continue;
//             } else {
//                 minCost += e.wt;
//                 union(e.src, e.dest);
//             }
//         }

//         return minCost;
//     }
// }
}
