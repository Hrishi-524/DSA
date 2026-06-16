package Graphs.sheet.part_2;
import java.util.*;

public class Matrix01 {
    class Solution {
    /**
        So instead of:
            Many 0s competing to update a cell
        you get:
            All 0s start together
            First arrival wins
        That's the entire idea behind Multi-Source BFS.
    */
    class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }

        int[] drows = {-1, 0, 1, 0};
        int[] dcols = {0, -1, 0, 1};


        while(!q.isEmpty()) {
            Pair curr = q.remove();
            
            for(int k=0; k<4; k++) {
                int x = curr.i + drows[k];
                int y = curr.j + dcols[k];

                if(x >=0 && x <n && y >=0 && y <m && !vis[x][y]) {
                    q.add(new Pair(x, y));
                    vis[x][y] = true;
                    res[x][y] = res[curr.i][curr.j] + 1;
                }
            }
        }

        return res;
    }
}
/**
Exactly. The mistake you made is actually one of the most valuable graph lessons.

You were unconsciously thinking:

> "Every 0 should try to improve every cell's answer."

which sounds like:

```text
answer[cell] = min(answer[cell], distance_from_this_zero)
```

That's a perfectly reasonable thought. In fact, that's conceptually what the problem is asking.

The issue is that BFS gives you something stronger:

> The first time a node is reached, its shortest distance is already known.

So instead of:

```text
Many 0s competing to update a cell
```

you get:

```text
All 0s start together
First arrival wins
```

That's the entire idea behind Multi-Source BFS.

---

Let's look at your current solution.

```java
if(x >=0 && x <n && y >=0 && y <m && !vis[x][y]) {
    q.add(new Pair(x, y));
    vis[x][y] = true;
    res[x][y] = res[curr.i][curr.j] + 1;
}
```

This is now the correct invariant.

When you execute:

```java
vis[x][y] = true;
```

you're saying:

> I have discovered the shortest path to this cell.

Not:

> I have visited it.

This distinction becomes important later.

In graph shortest-path problems, "visited" often really means:

```text
distance finalized
```

rather than

```text
seen before
```

---

Notice something elegant:

You removed:

```java
dist
Math.min(...)
backtracking thoughts
multiple updates
```

and the solution became simpler.

That's usually a sign you're closer to the correct graph abstraction.

---

Another lesson worth remembering:

### Single Source BFS

```text
Start from one node
Find distance to all nodes
```

Example:

```text
Shortest path in binary matrix
```

---

### Multi Source BFS

```text
Start from many nodes
Find distance to nearest source
```

Examples:

```text
01 Matrix
Rotten Oranges
Walls and Gates
Map of Highest Peak
As Far from Land as Possible
```

Whenever you see:

> "distance to nearest X"

or

> "spread from multiple starting points"

you should immediately suspect Multi-Source BFS.

---

One small improvement I'd suggest:

Instead of

```java
Queue<Pair> q = new LinkedList<>();
```

get into the habit of writing:

```java
Queue<Pair> q = new ArrayDeque<>();
```

For BFS queues in Java, `ArrayDeque` is generally preferred.

---

Most importantly, you discovered the key insight yourself:

> Because all sources are inserted initially, the first arrival at a cell is automatically the minimum distance.

That's not a trick for 542. That's one of the core BFS patterns that appears repeatedly in graph interviews and LeetCode. Once it clicks, a whole family of problems starts looking nearly identical.

 */
}
