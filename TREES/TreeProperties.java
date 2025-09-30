package TREES;

public class TreeProperties {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int countNodes(Node root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static int sumNodes(Node root) {
        if (root == null)
            return 0;
        return sumNodes(root.left) + sumNodes(root.right) + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Height: " + height(root));
        System.out.println("Node Count: " + countNodes(root));
        System.out.println("Sum of Nodes: " + sumNodes(root));
    }
}
