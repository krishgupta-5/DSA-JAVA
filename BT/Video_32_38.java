package BT;

public class Video_32_38 {
    public static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node leftClonedTree(Node root){
        if(root == null){
            return null; 
        }
        Node lnr = leftClonedTree(root.left);
        Node rnr = leftClonedTree(root.right);
        Node newNode = new Node(root.data);
        newNode.left = lnr;
        root.left = newNode;
        root.right = rnr;
        return root;
    }

    public static Node leftClonedTreeBack(Node root){
        if(root == null){
            return null; 
        }
        Node lnr = leftClonedTreeBack(root.left.left);
        Node rnr = leftClonedTreeBack(root.right);
        root.left = lnr;
        root.right = rnr;
        return root;
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        root.left.right = new Node('e');
        root.right.left = new Node('f');
        root.right.right = new Node('g');
        System.out.println("Original Tree:");
        preOrder(root);
        leftClonedTree(root);
        System.out.println("\nLeft Cloned Tree:");
        preOrder(root);
        System.out.println("\nRestored Original Tree:");
        leftClonedTreeBack(root);
        preOrder(root);

    }
}
