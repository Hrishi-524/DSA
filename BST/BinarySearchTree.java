package BST;

import TreeBinary.BinaryTreesB.Node;

public class BinarySearchTree {
    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static Node buildBST(int[] values) {
        Node root = null;
        for(int val : values) { 
            root = insert(root, val);
        }
        return root;   
    }

    public static boolean search(Node root, int key) { //O(H)
        if (root == null) {
            return false;
        }

        if(key < root.data) search(root.left, key);
        if(key > root.data) search(root.right, key);

        return true;
    }

    public static Node delete(Node root, int val) {
        //search in bst for the node 
        if(val < root.data) {
            root.left = delete(root.left, val);
            return root;
        } else if(val > root.data) {
            root.right = delete(root.right, val);
            return root;
        } else {
            // now root = node to be deleted

            //case 1 - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            //case 2 - node with single child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            //case 3 - node with two child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

            return root;
        }
    }
    
    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInorder(Node root) {
        if(root == null) {
            // System.out.print("-1 ");
            return;
        }
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = buildBST(values);

        printInorder(root);
    }
}