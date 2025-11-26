package TreeBinary;

import TreeBinary.BinaryTreesB.BinaryTree;
import TreeBinary.BinaryTreesB.Node;
// import TreeBinary.LowestCommonAncestor;

public class MinDistBwNodes {
    static int lcaDist(Node root, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1) {
            return rightDist+1;
        } else if(rightDist == -1) {
            return leftDist+1;
        } else {
            return -1;
        }
    }
    public static int minDist(Node root, int n1, int n2) {
        Node lca = LowestCommonAncestor.LCA2(root, n1, n2);
        System.out.println(lca.data);
        int dist1 = lcaDist(lca, n1);
        System.out.println(dist1);
        int dist2 = lcaDist(lca, n2);
        System.out.println(dist2);

        return dist1+dist2;
    }
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildPreorder(preorder);
        System.out.println(minDist(root, 4, 7));
    }
}
