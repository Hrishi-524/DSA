package TreeBinary.sheet;

import java.util.*;

public class BottomView {
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
            int x;
            Tuple(Node node, int x) {
                this.node = node;
                this.x = x;
            }
        }
        public ArrayList<Integer> topView(Node root) {
            if(root == null) return new ArrayList<>();
            
            Queue<Tuple> q = new LinkedList<>();
            
            q.offer(new Tuple(root, 0));
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            while(!q.isEmpty()) {
                Tuple curr = q.poll();
                Node node = curr.node;
                int x = curr.x;
                
                map.put(x, node.data);
                
                if(node.left != null) q.offer(new Tuple(node.left, x-1));
                if(node.right != null) q.offer(new Tuple(node.right, x+1));
            }
            
            ArrayList<Integer> list = new ArrayList<>();
            for(Integer value : map.values()) {
                list.add(value);
            }
            
            return list;
        }
    }
}
