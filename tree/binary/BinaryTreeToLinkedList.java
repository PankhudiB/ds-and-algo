package tree.binary;

import tree.Node;
import tree.Traversal;
import tree.util.Util;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeToLinkedList {
    Node prev = null;

    public static void main(String[] args) {
        BinaryTreeToLinkedList l = new BinaryTreeToLinkedList();
        Traversal t = new Traversal();

        Node tree1 = Util.getBinaryTreeVariant1();
        t.inOrder(tree1);
        System.out.println("---");
        Node result1 = l.toLL(tree1);
        t.inOrder(result1);
        System.out.println("----------");

        Node tree2 = Util.getCompleteBinaryTree();
        t.inOrder(tree2);
        System.out.println("-");
        Node result2 = l.toLL(tree2);
        t.inOrder(result2);
        System.out.println("----------");
    }

    public Node toLL(Node root) {
        prev = null;
        flatten(root);
        return root;
    }

    private void flatten(Node node) {
        if (node == null) return;
        flatten(node.right);
        flatten(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }
}

