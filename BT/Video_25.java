package BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Video_25 {
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

    public static void kLevelDown(Node root, int k, Node blocker) {
        if (root == null) return;
        int currLevel = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node n = queue.remove();
                level.add(n.data);
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            if (currLevel == k) {
                System.out.println(level);
                break;
            }
            currLevel++;
        }
    }

    static ArrayList<Integer> path;
    public static boolean nodeToRoot(Node root, int data){
        if(root == null){
            return false;
        }
        if(root.data == data){
            path.add(root.data);
            return true;
        }

        boolean left = nodeToRoot(root.left, data);
        if(left){
            path.add(root.data);
            return true;
        }

        boolean right = nodeToRoot(root.right, data);
        if(right){
            path.add(root.data);
            return true;
        }
        return false;
    }

    public void printKNodesFar(Node root, int data, int k) {
        path = new ArrayList<>();
        nodeToRoot(root, data);

        for (int i = 0; i < path.size(); i++) {
            Node blocker = (i == 0) ? null : new Node(path.get(i - 1));
            kLevelDown(new Node(path.get(i)), k - i, blocker);
        }
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
        nodeToRoot(root, 0);
        kLevelDown(root, 0, root);
    }
}
