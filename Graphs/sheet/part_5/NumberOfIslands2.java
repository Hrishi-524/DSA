package Graphs.sheet.part_5;

import java.util.*;

/*
    Number of Islands II (DSU)

    Idea:
    - Initially everything is WATER.
    - Each operation converts one WATER -> LAND.
    - A new LAND is assumed to be a NEW island.
        => islands++

    - Check all 4 neighbours.
    - If neighbour is LAND and belongs to a DIFFERENT component:
        union(curr, neighbour)
        => islands--      // two islands merged into one

    - If land is added again at same cell:
        ignore, answer stays same.

    Why DSU?
    - We DON'T recount islands after every operation.
    - We MAINTAIN the island count incrementally.

    Flattening:
        (i, j) -> i * m + j

    Time:
        O(Q * α(N))
        Q = number of operations
*/
/*
    New Land  -> islands++
    Successful Union -> islands--
    Duplicate Land -> ignore

    Maintain answer, DON'T recompute.

    Flatten:
        id = i * m + j

    DSU = Dynamic Connectivity
*/

public class NumberOfIslands2 {
    class Solution {
        public class DisjointSet {
            int[] par;
            int[] rank;
            int[] size;

            public DisjointSet(int n) {
                par = new int[n];
                rank = new int[n];
                size = new int[n];

                for(int i=0; i<n; i++) {
                    par[i] = i;
                    size[i] = 1;
                }
            }

            int find(int x) {
                if(x == par[x]) return x;
                return par[x] = find(par[x]);
            }

            boolean unionByRank(int a, int b) {
                int parA = find(a);
                int parB = find(b);

                if(parA == parB) return false;

                if(rank[parA] == rank[parB]) {
                    par[parB] = parA;
                    rank[parA]++;
                } else if(rank[parA] > rank[parB]) {
                    par[parB] = parA;
                } else {
                    par[parA] = parB;
                }

                return true;
            }

            boolean unionBySize(int a, int b) {
                int parA = find(a);
                int parB = find(b);

                if(parA == parB) return false;

                if(size[parA] < size[parB]) {
                    par[parA] = parB;
                    size[parB] += size[parA];
                } else {
                    par[parB] = parA;
                    size[parA] += size[parB];
                }   

                return true;
            }
        }

        public List<Integer> numOfIslands(int n, int m, int[][] A) {
            DisjointSet ds = new DisjointSet(n*m);

            int[][] grid = new int[n][m];

            int[] drows = {1, 0, -1, 0};
            int[] dcols = {0, 1, 0, -1};

            List<Integer> ans = new ArrayList<>();

            int islands = 0;

            for(int i=0; i<A.length; i++) {
                int x = A[i][0];
                int y = A[i][1];

                if(grid[x][y] == 1) {
                    ans.add(islands);
                    continue;
                }

                int currFlat = m*x+y;
                islands++;

                grid[x][y] = 1;
                

                for(int k=0; k<4; k++) {
                    int dx = x + drows[k];
                    int dy = y + dcols[k];
                    if((dx>=0 && dy>=0 && dx<n && dy<m) && grid[dx][dy] == 1) {
                        int sideFlat = m*dx+dy;
                        if(ds.unionBySize(currFlat, sideFlat)) {
                            islands--;
                        }
                    }
                }

                ans.add(islands);
            }

            return ans;
        }
    }
}