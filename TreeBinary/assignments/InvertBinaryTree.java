package TreeBinary.assignments;

import TreeBinary.BinaryTreesB.BinaryTree;
import TreeBinary.BinaryTreesB.Node;

public class InvertBinaryTree {
    public static Node invertTree(Node root) {
        if(root == null) {
            return root;
        }

        //swap root's left and right
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildPreorder(preorder);

        tree.printPreorder(root);

        invertTree(root);
        System.out.println();
        tree.printPreorder(root);
    }
}
