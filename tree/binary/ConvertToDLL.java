package tree.binary;

import tree.Node;
import tree.util.Util;

class ConvertToDLL {
    Node dllHead;

    public static void main(String[] args) {
        ConvertToDLL l = new ConvertToDLL();

        Node dll1 = l.convertToDLL(Util.getBinaryTreeVariant1());
        l.forwardAndBackward(dll1);
        System.out.println("\n-------------------------");

        l.forwardAndBackward(l.convertToDLL(Util.getCompleteBinaryTree()));
        System.out.println("\n-------------------------");

    }

    public Node convertToDLL(Node root) {
        dllHead = new Node(-1);
        Node headOfDLL = dllHead;
        inorder(root);
        headOfDLL = headOfDLL.right;
        headOfDLL.left = null;
        return headOfDLL;
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        dllHead.right = node;
        node.left = dllHead;
        dllHead = dllHead.right;
        inorder(node.right);
    }

    public void forwardAndBackward(Node node) {
        System.out.println("forward");
        Node tail = node;
        while (node != null) {
            System.out.print(node.val + " --> ");
            tail = node;
            node = node.right;
        }

        System.out.println("\nbackward");
        while (tail != null) {
            System.out.print(tail.val + " --> ");
            tail = tail.left;
        }
    }
}

