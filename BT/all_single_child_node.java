package BT;

public class all_single_child_node {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void printSingleChildNodes(Node root){
        if(root==null){
            return;
        }
        if(root.left != null && root.right == null || root.right != null && root.left == null){
            System.out.println(root.data);
        }
        printSingleChildNodes(root.left);
        printSingleChildNodes(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(72);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.right.right = new Node(87);
        root.left.right.left = new Node(30);
        root.left.right.right = new Node(40);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);
        root.right.left.left.left = new Node(70);
        root.right.right.right = new Node(70);
        printSingleChildNodes(root);
    }
}
