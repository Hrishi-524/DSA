package TreeBinary;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesB {
    public static class Node {
        public int data;
        public Node left;
        public Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int preidx = -1;
        static int postidx = -1;
        static int inidx = -1;

        public Node buildPreorder(int[] preorder) {
            preidx++;
            if(preorder[preidx] == -1) {
                return null;
            }

            Node newNode = new Node(preorder[preidx]);

            newNode.left = buildPreorder(preorder);
            newNode.right = buildPreorder(preorder);

            return newNode;
        } 

        public void printPreorder(Node root) {
            if (root == null) {
                System.out.print("-1 ");
                return;
            }

            System.out.print(root.data+" ");
            printPreorder(root.left);
            printPreorder(root.right);
        }

        public void printInorder(Node root) {
            if(root == null) {
                // System.out.print("-1 ");
                return;
            }
            printInorder(root.left);
            System.out.print(root.data+" ");
            printInorder(root.right);
        }

        public void printPostorder(Node root) {
            if(root == null) {
                // System.out.print(" -1");
                return;
            }
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data+" ");
        }

        public void printLevelorder(Node root) {
            if(root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();
                if(curr == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data+" ");
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
                }
            }
        }

        public int height(Node root) {
            if(root == null) {
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh, rh) + 1;
        }

        public int countNodes(Node root) {
            if(root == null) {
                return 0;
            }

            int lc = countNodes(root.left);
            int rc = countNodes(root.right);

            return lc + rc + 1;
        }

        public int sumOfNodes(Node root) {
            // if(root == null) {
            //     return 0;
            // }

            // int ls = sumOfNodes(root.left);
            // int rs = sumOfNodes(root.right);

            // return ls + rs + root.data;
            return root == null ? 0 : sumOfNodes(root.left)+sumOfNodes(root.right)+root.data;
        }

        public int diameterBruteForce(Node root) {// O(n^2)
            if(root == null) {
                return 0;
            }

            int diam = height(root.left) + height(root.right) + 1;

            int ld = diameterBruteForce(root.left);
            int rd = diameterBruteForce(root.right);

            return Math.max(diam, Math.max(ld, rd));
        }

        static class tuple {
            int diameter;
            int height;
            tuple(int diameter, int height) {
                this.diameter = diameter;
                this.height = height;
            }
        }

        public tuple diameter(Node root) {// O(n)
            if(root == null) {
                return new tuple(0, 0);
            }

            tuple lt = diameter(root.left);
            tuple rt = diameter(root.right);

            int diameter = lt.diameter + rt.diameter + 1;
            int height = lt.height + rt.height + 1;

            tuple tu = new tuple(diameter, height);

            return tu;
        }
    }

    public static void main(String[] args) {
        // int[] preorder = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int[] preorder = {1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildPreorder(preorder);
        // tree.printPreorder(root);
        // System.out.println();
        // tree.printInorder(root);
        // System.out.println();
        // tree.printPostorder(root);
        // System.out.println();
        // tree.printLevelorder(root);
        System.out.println(tree.height(root));
        System.out.println(tree.countNodes(root));
        System.out.println(tree.sumOfNodes(root));
        System.out.println(tree.diameterBruteForce(root));
    }
}