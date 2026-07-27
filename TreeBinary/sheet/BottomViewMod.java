package TreeBinary.sheet;
import java.util.*;

public class BottomViewMod {
    class Node {
        int data;
        Node left, right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    class Solution {
        class Tuple {
            Node node;
            int x, depth;
            Tuple(Node node, int x, int depth) {
                this.node = node;
                this.x = x;
                this.depth = depth;
            }
        }

        class Pair {
            int data, depth;

            Pair(int data, int depth) {
                this.data = data;
                this.depth = depth;
            }
        }

        public ArrayList<Integer> bottomViewMod(Node root) {
            Queue<Tuple> q = new LinkedList<>();
            
            TreeMap<Integer, Pair> map = new TreeMap<>();
            q.offer(new Tuple(root, 0, 0));

            while(!q.isEmpty()) {
                Tuple curr = q.poll();

                Node node = curr.node;
                int x = curr.x;
                int currDepth = curr.depth;        

                /*
                    1. Key doesnt exists -> put for first time
                    2. Key exists -> if depth of value and level match -> put minimum of both
                    3. Key exists -> keep value with higher depth
                */

                Pair exising = map.get(x);

                if(exising == null) {
                    // This is same as !map.containsKey(x) or map.putIfAbsent(x, ...)
                    map.put(x, new Pair(node.data, currDepth));
                }
                else if(currDepth > exising.depth) {
                    // continuous updation just like normal bottom view
                    map.put(x, new Pair(node.data, currDepth));
                } 
                else if(exising.depth == currDepth && node.data < exising.data) {
                    // overlapping nodes : smaller gets stored
                    map.put(x, new Pair(node.data, currDepth));
                } 

                if(node.left != null) q.offer(new Tuple(node.left, x-1, currDepth+1));
                if(node.right != null) q.offer(new Tuple(node.right, x+1, currDepth+1));
            }

            ArrayList<Integer> list = new ArrayList<>();
            for(Pair value : map.values()) {
                list.add(value.data);
            }

            return list;
        }
    }
}
