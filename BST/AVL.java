package BST;

public class AVL {
    public class Node {
        public int data, height;
        public Node left, right;
         public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 0;
        }
    }

    public static Node insert(Node root, int key) {

        if(key < root.data)
            root = insert(root.left, key);
        else if(key > root.data)
            root = insert(root.right, key);
        else 
            return root;

        return root;
    }
    public static void main(String[] args) {
        
    }
}
