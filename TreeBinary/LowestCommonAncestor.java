package TreeBinary;

import java.util.ArrayList;

import TreeBinary.BinaryTreesB.Node;

public class LowestCommonAncestor {

    static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        if(root.data == n) {
            return true;
        }

        path.add(root);

        return getPath(root.left, n, path) || getPath(root.right, n, path);
    }
    public static Node LCA(Node root, int n1, int n2) {
        ArrayList<Node> pathN1 = new ArrayList<>();
        ArrayList<Node> pathN2 = new ArrayList<>();
        getPath(root, n1, pathN1);
        getPath(root, n2, pathN2);
        
        int i=0;
        for(; i<pathN1.size() && i<pathN2.size(); i++) {
            if(pathN1.get(i) !=  pathN2.get(i)) {
                break;
            }
        }

        Node lca = pathN1.get(i);
        return lca;
    }

    public static Node LCA2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;//if root == null then it returns null
        }

        Node leftLca = LCA2(root.left, n1, n2);
        Node rightLca = LCA2(root.right, n1, n2);
        
        if(rightLca == null) {
            return leftLca;
        }

        if(leftLca == null) {
            return rightLca;
        }

        return root;
    }
    public static void main(String[] args) {
        
    }
}
