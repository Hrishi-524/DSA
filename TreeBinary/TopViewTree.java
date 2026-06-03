package TreeBinary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import TreeBinary.BinaryTreesB.Node;

public class TopViewTree {
    //tuple will store node + its horizontal distance
    static class tuple {
        int hd;
        Node node;
        tuple(int hd, Node node) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topview(Node root) {
        //for inorder traversal we make queue
        Queue<tuple> q = new LinkedList<>();
        //hashmap as helper
        HashMap<Integer,Node> map = new HashMap<>();

        //inorder traversal
        q.add(new tuple(0, root));
        q.add(null);

        int max = 0, min = 0;

        while (!q.isEmpty()) {
            tuple curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null) {
                    q.add(new tuple(curr.hd-1, curr.node.left));
                    min = Math.min(curr.hd-1, min);
                }

                if(curr.node.right != null) {
                    q.add(new tuple(curr.hd+1, curr.node.right));
                    max = Math.max(curr.hd+1, max);
                }
            }
        }

        for(int i=min; i<=max; i++) {
            System.err.print(map.get(i).data+" ");
        }
    }       
    public static void main(String[] args) {
        
    }
}
