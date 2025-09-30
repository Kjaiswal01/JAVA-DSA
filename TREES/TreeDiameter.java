package TREES;

public class TreeDiameter {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class TreeInfo {
        int height, diam;

        TreeInfo(int height, int diam) {
            this.height = height;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter(Node root) {
        if (root == null)
            return new TreeInfo(0, 0);

        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int diam1 = left.height + right.height + 1;
        int diam2 = left.diam;
        int diam3 = right.diam;

        int diam = Math.max(diam1, Math.max(diam2, diam3));
        return new TreeInfo(height, diam);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Diameter of tree: " + diameter(root).diam);
    }
}
