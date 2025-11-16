package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Array.kPairWithSmallestSum;

public class pathToLeafFromRoot {
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
    static ArrayList<Integer> list;
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
        newTree.right.left.right = new Node(70);
        newTree.left.left.left = new Node(5);
        // helper(newTree, "", 0, 150, 250);
        list = new ArrayList<>();
        // Node clonedTree = createLeftClone(newTree);
        // // inOrder(clonedTree);
        // System.out.println();
        // Node newNode = transBack(clonedTree);
        // inOrder(newNode);

        // System.out.println(list);
        // oneChild(newTree);
        Node newNode = removeLeafNode(newTree);
        inOrder(newNode);
        System.out.println(list);
    }

    public static void helper(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sum += node.val;
            if (sum > lo && sum < hi) {
                System.out.println(path + node.val);
                System.out.println(sum);
            }
            return;
        }
        helper(node.left, path + node.val + " ", sum + node.val, lo, hi);
        helper(node.right, path + node.val + " ", sum + node.val, lo, hi);
    }

    public static Node createLeftClone(Node node) {
        if (node == null) {
            return null;
        }

        Node lcr = createLeftClone(node.left);
        Node rcr = createLeftClone(node.right);

        Node nn = new Node(node.val);
        nn.left = lcr;

        node.left = nn;
        node.right = rcr;

        return node;
    }

    
    public static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    public static Node transBack(Node node){
        if(node == null){
            return null;
        }
        Node lnn = transBack(node.left.left);
        Node rnn = transBack(node.right);

        node.left = lnn;
        node.right = rnn;
        return node;
    }

    public static void oneChild(Node node){
        if(node == null){
            return;
        }

        if(node.left == null && node.right != null){
            System.out.println(node.val);
        }
        if(node.left != null && node.right == null){
            System.out.println(node.val);
        }
        oneChild(node.left);
        oneChild(node.right);

    }   


    public static Node removeLeafNode(Node node){
        if(node == null){
            return null;
        }

        if(node.left == null && node.right == null){
            return null;
        }

        node.left = removeLeafNode(node.left);
        node.right = removeLeafNode(node.right);

        return node;
    }
}
