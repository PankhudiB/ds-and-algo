package tree.binary;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

class LeftAndRightView {
    static int maxSoFar;
    static LinkedList<Node> leftViewForSoln2;
    static LinkedList<Node> rightViewForSoln2;

    public static void main(String[] args) {
        LeftAndRightView l = new LeftAndRightView();

        System.out.println("Left view : ");
        LinkedList<Node> leftViewOfT1 = l.leftView(l.getBinaryTreeVariant1());
        leftViewOfT1.forEach(System.out::println);
        System.out.println("---");
        LinkedList<Node> leftViewOfT2 = l.leftView(l.getCompleteBinaryTree());
        leftViewOfT2.forEach(System.out::println);
        System.out.println("---");

        //----------

        LinkedList<Node> leftViewOfT3 = l.leftViewRecursive(l.getBinaryTreeVariant1());
        leftViewOfT3.forEach(System.out::println);
        System.out.println("---");
        LinkedList<Node> leftViewOfT4 = l.leftViewRecursive(l.getCompleteBinaryTree());
        leftViewOfT4.forEach(System.out::println);
        System.out.println("---");

        System.out.println("Right view : ");
        LinkedList<Node> rightViewOfT1 = l.rightViewRecursive(l.getBinaryTreeVariant1());
        rightViewOfT1.forEach(System.out::println);
        System.out.println("---");
    }

    public LinkedList<Node> leftView(Node root) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        LinkedList<Node> leftView = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            leftView.add(q1.peek());
            while (!q1.isEmpty()) {
                Node node = q1.poll();
                if (node.left != null) q2.add(node.left);
                if (node.right != null) q2.add(node.right);
            }
            Queue<Node> temp = q2;
            q2 = q1;
            q1 = temp;
        }
        return leftView;
    }

    public LinkedList<Node> leftViewRecursive(Node node) {
        leftViewForSoln2 = new LinkedList<>();
        maxSoFar = 0;
        leftViewRecursive(node, 1);
        return leftViewForSoln2;
    }

    private void leftViewRecursive(Node node, int level) {
        if (node == null) return;
        if (maxSoFar < level) {
            leftViewForSoln2.add(node);
            maxSoFar = level;
        }
        if (node.left != null) leftViewRecursive(node.left, level + 1);
        if (node.right != null) leftViewRecursive(node.right, level + 1);
    }

    public LinkedList<Node> rightViewRecursive(Node node) {
        rightViewForSoln2 = new LinkedList<>();
        maxSoFar = 0;
        rightViewRecursive(node, 1);
        return rightViewForSoln2;
    }

    private void rightViewRecursive(Node node, int level) {
        if (node == null) return;
        if (maxSoFar < level) {
            rightViewForSoln2.add(node);
            maxSoFar = level;
        }
        if (node.right != null) rightViewRecursive(node.right, level + 1);
        if (node.left != null) rightViewRecursive(node.left, level + 1);
    }

    private Node getBinaryTreeVariant1() {
//                    10
//                 /      \
//                9         20
//                        /    \
//                      15      7
//                        \    /
//                         3   8

        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node15 = new Node(15);
        Node node20 = new Node(20);
        Node node3 = new Node(3);
        Node node8 = new Node(8);

        node10.left = node9;
        node10.right = node20;
        node20.left = node15;
        node20.right = node7;
        node15.right = node3;
        node7.left = node8;

        return node10;
    }

    private static Node getCompleteBinaryTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

//                  1
//                /   \
//               2     3
//              / \   / \
//             4   5  6   7
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        return node1;
    }
}

