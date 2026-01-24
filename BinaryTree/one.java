package BinaryTree;

import java.util.ArrayList;

public class one {
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
        newTree.right.left.left = new Node(70);

        // path = new ArrayList<>();

        // System.out.println(find(newTree,70));
        // for(int i = path.size() - 1; i >=0; i = i - 1){
        //     System.out.print(path.get(i) + " ");
        // }
        // System.out.println();

        // printKLevelDown(newTree, 2);
        // pathToLeafFromRoot(newTree, "", 0, 150, 250);
        Node newNode = createLeftClone(newTree);
        list = new ArrayList<>();
        inOrder(newNode);
        for(int i = 0; i < list.size(); i = i + 1){
            System.out.print(list.get(i) + " ");
        }
        list.clear();
        System.out.println();
        Node transNode = transBack(newNode);
        inOrder(transNode);
        for(int i = 0; i < list.size(); i = i + 1){
            System.out.print(list.get(i) + " ");
        }

    }

    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }
        if(node.val == data){
            path.add(node.val);
            return true;
        }

        boolean findLeft = find(node.left, data);
        if(findLeft){
            path.add(node.val);
            return true;
        }

        boolean findRight = find(node.right, data);
        if(findRight){
            path.add(node.val);
            return true;
        }

        return false;
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

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            sum += node.val;
            if(sum > lo && sum < hi){
                System.out.println(path + node.val);
                System.out.println(sum);
            }
            return;
        }
        pathToLeafFromRoot(node.left, path + node.val + " ", sum + node.val, lo, hi);
        pathToLeafFromRoot(node.right, path + node.val + " ", sum + node.val, lo, hi);
    }

    public static Node createLeftClone(Node node){
        if(node == null){
            return null;
        }

        Node lcr = createLeftClone(node.left);
        Node rcr = createLeftClone(node.right);

        Node nn = new Node(node.val);
        nn.left = lcr;
        nn.right = rcr;
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
}
