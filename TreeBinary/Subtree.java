package TreeBinary;
import TreeBinary.BinaryTreesB.*;

public class Subtree {

    static boolean isIdentical(Node node, Node subroot) {
        if(node == null && subroot == null) {
            return true;
        } else if(node == null || subroot == null) {
            return false;
        }

        // if (!isIdentical(node.left, subroot.left)) {
        //     return false;
        // }

        // if (!isIdentical(node.right, subroot.right)) {
        //     return false;
        // }
        
        // return true;

        return isIdentical(node.left, subroot.left) && isIdentical(node.right, subroot.right);
    }

    public static boolean isSubtree(Node root, Node subroot) {  
        if(root.data == subroot.data && isIdentical(root, subroot)) {
            return true;
        }

        boolean liesLeft = isSubtree(root.left, subroot);
        boolean liesRight = isSubtree(root.right, subroot);

        return liesLeft || liesRight;
    }
    public static void main(String[] args) {
        
    }
}