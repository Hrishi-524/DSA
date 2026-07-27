package TreeBinary.sheet;

import java.util.*;

public class BurningTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class Solution {
        class Tuple {
            Node node;
            int time;
            Node par;

            Tuple(Node node, int time) {
                this.node = node;
                this.time = time;
            }

            Tuple(Node node, Node par) {
                this.node = node;
                this.par = par;
            }
        }
        
        public int minTime(Node root, int target) {
            if(root == null) return 0;
            
            HashMap<Node, Node> parents = new HashMap<>();
            Queue<Tuple> q = new LinkedList<>();
            q.offer(new Tuple(root, null));

            Node tar = null;
            while (!q.isEmpty()) {
                Tuple curr = q.poll();

                Node node = curr.node;
                Node par = curr.par;

                if(node.data == target) {
                    tar = node;
                }

                if(par != null) parents.put(node, par);

                if(node.left != null) q.offer(new Tuple(node.left, node));
                if(node.right != null) q.offer(new Tuple(node.right, node));
            }

            q.clear();

            HashSet<Node> visited = new HashSet<>();
            
            q.offer(new Tuple(tar, 0));
            visited.add(tar);
            
            int maxTime = Integer.MIN_VALUE;
            
            while(!q.isEmpty()) {
                Tuple curr = q.poll();
                
                Node currNode = curr.node;
                int timeSoFar = curr.time;
                
                maxTime = Math.max(maxTime, timeSoFar);
                
                if (currNode.left != null && visited.add(currNode.left)) {
                    q.offer(new Tuple(currNode.left, timeSoFar + 1));
                }

                if (currNode.right != null && visited.add(currNode.right)) {
                    q.offer(new Tuple(currNode.right, timeSoFar + 1));
                }

                Node par = parents.get(currNode);
                if (par != null && visited.add(par)) {
                    q.offer(new Tuple(par, timeSoFar + 1));
                }
            }
            
            return maxTime;
        }
    }
}
