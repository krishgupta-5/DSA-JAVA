package BT;

public class PS01 {
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

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(23);
        root.right = new Node(2);
        root.left.left = new Node(39);
        root.left.right= new Node(54);
        root.right.left = new Node(9);
        root.right.right = new Node(45);

        inOrder(root);
    }
}