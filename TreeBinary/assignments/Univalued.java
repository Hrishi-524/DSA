package TreeBinary.assignments;

import TreeBinary.BinaryTreesB.BinaryTree;
import TreeBinary.BinaryTreesB.Node;

public class Univalued {
    public static boolean isUnivalued(Node root, int val) {
        //traverse each node and check if each node has same data , if any node differs at any stage 
        //immidiately return false, otherwise true
        if(root == null) {
            return true;
        }   

        if(root.data != val) {
            return false;
        }

        return root.data == val && isUnivalued(root.left, val) && isUnivalued(root.right, val);

    }
    public static void main(String[] args) {
        int[] preorder = {10, 10, 10, -1, -1, 11, -1, 10, -1, 10, -1, -1, 10, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildPreorder(preorder);

        System.out.println(isUnivalued(root, root.data));
    }
}
