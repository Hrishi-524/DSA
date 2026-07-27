package TreeBinary.sheet;

import java.util.ArrayList;

public class BoundryTraversal {
    class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    } 

    class Solution {
        public ArrayList<Integer> boundaryTraversal(Node root) {
            // code here
            if(root == null) return new ArrayList<>();
            
            ArrayList<Integer> boundry = new ArrayList<>();
            
            if(!isLeaf(root)) {
                boundry.add(root.data);
            }
            
            if(root.left != null) leftBoundry(root.left, boundry);
            
            leafBoundry(root, boundry);
            
            if(root.right != null) rightBoundry(root.right, boundry);
            
            return boundry;
        }
        
        private boolean isLeaf(Node root) {
            return root.left == null && root.right == null;
        }
        
        private void leftBoundry(Node root, ArrayList<Integer> boundry) {
            if(root == null || isLeaf(root)) {
                return;
            }
            
            boundry.add(root.data);
            
            // prefer left child if it exists, otherwise go to right child
            if(root.left != null) {
                leftBoundry(root.left, boundry);
            } else { // left is null and right is not null (because if right is null it would go in leaf check)
                leftBoundry(root.right, boundry);
            }
        }
        
        private void leafBoundry(Node root, ArrayList<Integer> boundry) {
            if(isLeaf(root)) {
                boundry.add(root.data);
                return;
            }
            
            if(root.left != null) leafBoundry(root.left, boundry);
            if(root.right != null) leafBoundry(root.right, boundry);
        }
        
        private void rightBoundry(Node root, ArrayList<Integer> boundry) {
            if(root == null || isLeaf(root)) {
                return;
            }
            
            
            if(root.right != null) {
                rightBoundry(root.right, boundry);
            } else {
                rightBoundry(root.left, boundry);
            }
            
            boundry.add(root.data);
        }
    }
}
