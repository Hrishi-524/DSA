package Graphs;

public class Disjoint {
    static int n = 8;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for(int i=0; i<par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) { // O(4K) ~ O(1)
        if(x == par[x]) {
            return x;
        }

        // assigning par[x] = find(x) is called path compression optimization
        return par[x] = find(x);
    }

    public static void union(int x, int y) { // O(4K) ~ O(1)
        int parX = find(x);
        int parY = find(y);

        if(rank[parX] == rank[parY]) {
            par[parX] = parY;
            parY++;
        } else if (rank[parX] > rank[parY]) {
            par[parY] = parX;
        } else {
            par[parX] = parY;
        }
    }

    public static void main(String[] args) {
        
    }
}