package BST;
// import java.util.ArrayList;

// import TreeBinary.BinaryTreesB.BinaryTree;
import TreeBinary.BinaryTreesB.Node;
// import BST.BinarySearchTree;

public class BSTPracticeProblems {
    /*
    PRACTICE PROBLEMS 
    */
    
    /*
    QUESTION 1:
    We have a Binary Search Tree consisting of N nodes and two positive integers L and R,
    the task is to find the sum of values of all the nodes that lie in the range [L, R]..
    */
    public static int rangeSum(Node root, int L, int R) {
        if(root == null) {
            return 0;
        }

        if(L <= root.data && root.data <= R) {
            return rangeSum(root.left, L, R) + rangeSum(root.right, L, R) + root.data;
        } else if (root.data < L) {
            return rangeSum(root.right, L, R);
        } else {
            return rangeSum(root.left, L, R);
        }
    }

    /*
        QUESTION 2:
        We have a binary search tree and a target node K.
        The task is to find the node with minimum absolute difference with given target value K.
    */
    
    public static Node closestNode(Node root, int target) {
        return helper(root, target, Integer.MAX_VALUE, null);
    }

    private static Node helper(Node root, int target, int minDiff, Node closest) {
        if (root == null) return closest;

        int diff = Math.abs(root.data - target);
        if (diff < minDiff) {
            minDiff = diff;
            closest = root;
        }

        if (target < root.data) {
            return helper(root.left, target, minDiff, closest);
        } else if (target > root.data) {
            return helper(root.right, target, minDiff, closest);
        } else {
            return root; // exact match
        }
    }

    public static int count(Node root) {
        if(root == null) {
            return 0;
        }
        return count(root.left)+count(root.right)+1;
    }

    public static Node kthSmallestElt(Node root, int k) {

        int L = count(root.left);
        // you are (L+1)th in inorder
        if(k == L+1) {
            return root;
        }
        else if(k <= L) {
            // answer lies in left subtree
            return kthSmallestElt(root.left, k);
        } else {
            //answer lies in right subtree
            return kthSmallestElt(root.right, (k-(L+1))); // EXTREMELY IMPORTANT TO UPDATE K
            /*
                left subtree = [3, 5, 6]
                L = 3
                current node = 8 (4th smallest)
                Check:

                makefile
                Copy code
                k = 5
                L+1 = 4
                Since k > 4, answer is in right subtree.

                But now—

                In the right subtree…
                [11, 20]

                This subtree's inorder is:

                java
                Copy code
                1st smallest = 11  
                2nd smallest = 20
                So inside this subtree,
                you’re not looking for “5th smallest” anymore.

                You're looking for the (5 - 4) = 1st smallest.
            */
        }
    }

    static int sum = 0;

    void convertToGST(Node root) {
        if (root == null) return;

        // go to right first (larger values)
        convertToGST(root.right);

        int original = root.data;
        root.data = sum;   // replace with sum of greater nodes
        sum += original;   // update sum to include this node

        // go left (smaller values)
        convertToGST(root.left);
    }

    
    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = BST.BinarySearchTree.buildBST(values);
        /**
         *       5
         *      / \ 
         *     1   7
         *      \     
         *       3
         *      / \
         *     2   4
         */
        System.out.println(rangeSum(root, 3, 7));
    }
}
