package Graphs.sheet.part_3;

import java.util.*;

public class EventualSafeNodes {
    class Solution {
        @SuppressWarnings("unchecked")
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int V = graph.length;
            ArrayList<Integer>[] rgraph = new ArrayList[V];

            for(int i=0; i<V; i++) {
                rgraph[i] = new ArrayList<>();
            }
            for(int i=0; i<V; i++) {
                for(int nb : graph[i]) {
                    rgraph[nb].add(i);
                }
            }

            int[] indeg = calcIndeg(rgraph);
            Queue<Integer> q = new LinkedList<>();

            List<Integer> safeNodes = new ArrayList<>();

            for(int i=0; i<V; i++) {
                if(indeg[i] == 0) {
                    q.add(i);
                    safeNodes.add(i);
                }
            }

            while(!q.isEmpty()) {
                int curr = q.remove();

                for(int nb : rgraph[curr]) {
                    indeg[nb]--;
                    if(indeg[nb] == 0) {
                        q.add(nb);
                        safeNodes.add(nb);
                    }
                }
            }

            Collections.sort(safeNodes);

            return safeNodes;
        }

        public static int[] calcIndeg(ArrayList<Integer>[] graph) { // O(E)
            int[] indeg = new int[graph.length];
            for (int vertex=0; vertex<graph.length; vertex++) { 
                for(int nb: graph[vertex]) {
                    indeg[nb]++;
                }
            }
            return indeg;
        }
    }
}

/*
Great question — the reverse graph + topological sort approach can feel unintuitive at first, but here’s why it works:

---

### 🔄 Step 1: Reverse the graph
- In the original graph, edges go from a node → its neighbors.
- In the **reverse graph**, edges point backwards: neighbor → node.
- This reversal lets us propagate "safety" information backwards: if a terminal node is safe, then any node that only leads to safe nodes is also safe.

---

### 🧮 Step 2: Track outdegrees
- In the original graph, a **terminal node** has outdegree = 0.
- In the reverse graph, we start from these terminal nodes.
- Then we repeatedly remove nodes whose outgoing edges all lead to safe nodes (their outdegree drops to 0 as we process).

---

### 📊 Step 3: Topological process
- Think of it like Kahn’s algorithm for topological sorting:
  1. Put all terminal nodes (outdegree = 0) in a queue.
  2. Pop one node, mark it safe.
  3. For each predecessor (in the reverse graph), reduce its outdegree.
  4. If a predecessor’s outdegree becomes 0, it means **all its outgoing edges lead to safe nodes**, so it’s safe too.
  5. Continue until no more nodes can be marked safe.

---

### 🌐 Why this guarantees correctness
- A node is safe **iff all paths from it eventually lead to terminal nodes**.
- By processing in reverse, we only mark a node safe once we’ve confirmed that **every neighbor it points to is already safe**.
- Cycles never get reduced to outdegree = 0, so they remain unsafe.

---

### 🧩 Intuition
Imagine safety flowing backwards:
- Terminal nodes are trivially safe.
- Any node that only points to safe nodes becomes safe.
- This cascades until all safe nodes are discovered.
- Cycles block the cascade, so unsafe nodes never get marked.

---

👉 So the reverse graph + topological sort works because it systematically eliminates nodes that can only reach safe states, while cycles remain untouched.  

Would you like me to sketch out the **Java implementation** of this approach so you can compare it with the DFS coloring method?
*/
