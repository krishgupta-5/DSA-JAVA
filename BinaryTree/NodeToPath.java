package BinaryTree;
import java.util.ArrayList;

public class NodeToPath {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    static ArrayList<Integer> path;
    public static void main(String[] args) {
        Node newTree = new Node(50);
        newTree.left = new Node(25);
        newTree.right = new Node(75);
        newTree.left.left = new Node(12);
        newTree.left.right = new Node(37);
        newTree.right.left = new Node(62);
        newTree.right.right = new Node(87);
        newTree.left.right.left = new Node(30);
        newTree.left.right.right = new Node(40);
        newTree.right.left.left = new Node(60);
        newTree.right.left.left = new Node(70); 
        path = new ArrayList<>();

        // System.out.println(find(newTree, 70));
        // for (int i = path.size() - 1; i >= 0; i--) {
        //     System.out.print(path.get(i) + " ");
        // }

        printKLevelDown(newTree, 2);

    }

    public static void printKLevelDown(Node node, int k){
        if(node == null || k < 0){
            return;
        }
        if(k == 0){
            System.out.println(node.val);
        }
        printKLevelDown(node.left, k-1);
        printKLevelDown(node.right, k-1);
    }
    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }
        if(node.val == data){
            path.add(node.val);
            return true;
        }
        boolean fillc = find(node.left, data);
        if(fillc){
            path.add(node.val);
            return true;
        }
        boolean firc = find(node.right, data);
        if(firc){
            path.add(node.val);
            return true;
        }
        return false;
    }
}