package BT;

import java.util.*;

public class diagonal_order_at {
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

    static ArrayList<Integer> res;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(20);
        root.left.left = new Node(60);
        root.left.right = new Node(50);
        root.right.left = new Node(70);
        root.right.right = new Node(90);
        res = new ArrayList<>();
        helper(root);
        System.out.println(res.toString());
    }

    public static void helper(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i = i + 1){
                Node n = queue.remove();
                while(n != null){
                    res.add(n.data);

                    if(n.right != null){
                        queue.add(n.right);
                    }
                    n = n.left;
                }
            }
        }

    }
}
