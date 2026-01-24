package BT;

public class Video_4 {
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

    static int size;
    public static void findSize(Node root){
        if(root == null){
            return;
        }
        findSize(root.left);
        size++;
        findSize(root.right);
    }

    static int sum;

    public static void findSum(Node root){
        if(root == null){
            return;
        }
        findSum(root.left);
        sum += root.data;
        findSum(root.right);
    }

    static int max = Integer.MIN_VALUE;

    public static void findMax(Node root){
        if(root == null){
            return;
        }
        findMax(root.left);
        if(root.data > max){
            max = root.data;
        }
        findMax(root.right);
    }
    public static void main(String[] args) {
        size = 0;
        sum = 0;
        Node root = new Node(10);
        root.left = new Node(23);
        root.right = new Node(2);
        root.left.left = new Node(39);
        root.left.right= new Node(54);
        root.right.left = new Node(9);
        root.right.right = new Node(45);
        findSize(root);
        findSum(root);
        System.out.println("Size of Tree : "+size);
        System.out.println("Sum of Nodes : "+sum);
    }
}
