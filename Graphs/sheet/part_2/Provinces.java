package Graphs.sheet.part_2;

public class Provinces {
    class Solution {
    public int findCircleNum(int[][] isConnected) { // O(V+E)
        // We want to find number of connected components in the graph
        // Given Input is in form of Adjecency Matrix
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                provinces = provinces + 1;
                dfsUtil(isConnected, i, vis, n);
            }
        }

        return provinces;
    }

    void dfsUtil(int[][] isConnected, int curr, boolean[] vis, int n) {
        vis[curr] = true;

        for(int i=0; i<n; i++) {
            if(isConnected[curr][i] == 1 && !vis[i]) {
                dfsUtil(isConnected, i, vis, n);
            }
        }
    }
}
}