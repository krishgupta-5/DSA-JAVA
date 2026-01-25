package BT;

public class Video_28 {
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

    public static void rootToLeafSum(Node root, String path, int sum, int lo, int hi){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum += root.data; 
            path += root.data + " -> ";
            if(sum >= lo && sum <= hi){
                System.out.print(path);
            }
            return ;
        }
        rootToLeafSum(root.left, path, sum, lo, hi);
        rootToLeafSum(root.right, path, sum, lo, hi);
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
        rootToLeafSum(root, "", 0, 10, 150);
    }
}
