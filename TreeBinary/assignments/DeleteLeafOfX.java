package TreeBinary.assignments;

import TreeBinary.BinaryTreesB.BinaryTree;
import TreeBinary.BinaryTreesB.Node;

public class DeleteLeafOfX {

    public static Node delLeafWithVal(Node root, int val) {
        if (root == null) {
            return root;
        }

        if(root.left == null && root.right == null) {
            if(root.data == val) {
                return null;
            }
            return root;
        }

        root.left = delLeafWithVal(root.left, val);
        root.right = delLeafWithVal(root.right, val);

        return root;
    }
    public static void main(String[] args) {
        int[] preorder = {1, 3, 3, -1, -1, 5, -1, 3, -1, 3, -1, -1, 4, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildPreorder(preorder);

        delLeafWithVal(root, 3);

        tree.printPreorder(root);
    }
}
