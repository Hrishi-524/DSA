package Graphs.sheet.part_2;
import java.util.*;

public class FoodFill {
    class Solution {
    class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) {
            return image;
        }

        // Important mistake corrected
        int startColor = image[sr][sc];

        int n = image.length;
        int m = image[0].length;

        Queue<Pair> q = new ArrayDeque<>();

        q.offer(new Pair(sr, sc));
        image[sr][sc] = color;
        
        // [left, up, right, down]
        int[] drows = {-1, 0, 1, 0};
        int[] dcols = {0, -1, 0, 1};
        
        while(!q.isEmpty()) {
            Pair curr = q.poll();

            // left, up, right, down loop - neighbours
            for(int k=0; k<4; k++) {
                int x = curr.i + drows[k];
                int y = curr.j + dcols[k];

                if(x >=0 && x < n && y >= 0 && y < m && image[x][y] == startColor) {
                    q.offer(new Pair(x, y));
                    image[x][y] = color;
                }
            }
        }

        return image;
    }
}
}