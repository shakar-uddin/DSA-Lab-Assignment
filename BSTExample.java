class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
class BST {
    Node root;
    // Insert a node
    public Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data) root.left = insert(root.left, key);
        else root.right = insert(root.right, key);
        return root;
    }
    // Inorder traversal (Left, Root, Right)
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    // Preorder traversal (Root, Left, Right)
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    // Postorder traversal (Left, Right, Root)
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    // Search for a node
    public boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (key < root.data) return search(root.left, key);
        return search(root.right, key);
    }
    // Find minimum value
    public int findMin(Node root) {
        while (root.left != null) root = root.left;
        return root.data;
    }
    // Find maximum value
    public int findMax(Node root) {
        while (root.right != null) root = root.right;
        return root.data;
    }
    // Delete a node
    public Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) root.left = delete(root.left, key);
        else if (key > root.data) root.right = delete(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: get inorder successor
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }
    // Count total nodes
    public int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    // Count leaf nodes
    public int countLeafNodes(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }
    // Height of BST
    public int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
public class BSTExample{
    public static void main(String[] args) {
        BST tree = new BST();

        int[] elements = {50, 30, 70, 20, 40, 60, 80};
        for (int el : elements) {
            tree.root = tree.insert(tree.root, el);
        }

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder traversal: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder(tree.root);
        System.out.println();

        int searchKey = 60;
        System.out.println("Search " + searchKey + ": " + (tree.search(tree.root, searchKey) ? "Found" : "Not Found"));

        tree.root = tree.delete(tree.root, 80);
        System.out.print("Inorder after deleting 80: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Minimum value: " + tree.findMin(tree.root));
        System.out.println("Maximum value: " + tree.findMax(tree.root));

        System.out.println("Total nodes: " + tree.countNodes(tree.root));
        System.out.println("Leaf nodes: " + tree.countLeafNodes(tree.root));
        System.out.println("Height of BST: " + tree.height(tree.root));
    }
}
