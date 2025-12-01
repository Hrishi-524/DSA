package BST;

import java.util.ArrayList;

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
            /**
             *  1. Find IS
             *  2. Replace to-be-deleted node value with IS value 
             *  3. Delete IS from Right subtree of to-be-deleted node
             *  Since recursion is being followed to-be-deleted node = root 
             */
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

    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        } else if(root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    public static boolean leaf(Node root) {
        return root.left == null && root.right == null;
    }


    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.data);
        if(leaf(root)) {
            System.out.println(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.data <= min.data) {
            return false;
        }

        if(max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirror(Node root) {
        //base case
        if(root == null) {
            return null;
        }

        // calculate mirror of left subtree
        Node leftS = mirror(root.left);
        // calculate mirror of right subtree
        Node rightS = mirror(root.right);

        // calculate my own mirror (just swap left and right mirror's)
        root.left = rightS;
        root.right = leftS;

        // return tree/subtree
        return root;
    }

    public static Node arr2BalancedBST(int[] values, int st, int end) { 
        if(st >= end) {
            return null;
        }
        
        int mid = st+(end-st)/2;
        Node root = new Node(values[mid]);

        root.left = arr2BalancedBST(values, st, mid-1);
        root.right = arr2BalancedBST(values, mid+1, end);

        return root;
    }

    public static Node inorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) {
            return null;
        }

        inorder(root.left, inorder);
        inorder.add(root.data);
        inorder(root.right, inorder);

        return root;
    }

    public static Node arr2BalancedBST(ArrayList<Integer> values, int st, int end) { 
        if(st >= end) {
            return null;
        }
        
        int mid = st+(end-st)/2;
        Node root = new Node(values.get(mid));

        root.left = arr2BalancedBST(values, st, mid-1);
        root.right = arr2BalancedBST(values, mid+1, end);

        return root;
    }

    public static Node BST2BalancedBST(Node root) { //O(2n) ~ O(n)
        ArrayList<Integer> inorder = new ArrayList<>();

        root = inorder(root, inorder); // O(n)

        root = arr2BalancedBST(inorder, 0, inorder.size()-1); // O(n)

        return root;
    }

    private class Info {
        boolean isBST;
        int size, min, max;
        // void Info(boolean isBST,int size,int min,int max) {
        //     this.isBST = isBST;
        //     this.size = size;
        //     this.min = min;
        //     this.max = max;
        // } 
    }


    /**
     * 
     * REVISIT
     * 
     * 
     */
    
    public static Info sizeOfLargestBST(Node root, Info info) {
        if(root == null) {
            info.isBST = true;
            info.size = 1;
            info.min = 0;
            info.max = 0;
        }
        
        Info leftInfo = sizeOfLargestBST(root.left, info);
        Info rightInfo = sizeOfLargestBST(root.right, info);

        // 1. deciding if we are valid BST
        info.isBST = leftInfo.isBST && rightInfo.isBST;

        if (info.isBST) {
            info.isBST = isValidBST(root, new Node(Integer.MIN_VALUE), new Node(Integer.MAX_VALUE));
        }
        // 2. calculate own self size
        info.size = leftInfo.size + rightInfo.size + 1;

        // 3. calculate own min
        info.min = leftInfo.min;

        // 4. calculate own max
        info.max = rightInfo.max;

        return info;
        
    }

    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = buildBST(values);
        /**
         *       5
         *      / \ 
         *     1   7
         *      \     
         *       3
         *      / \
         *     2   4
         */
        ArrayList<Integer> path = new ArrayList<>();
        printRoot2Leaf(root, path);
    }
}   