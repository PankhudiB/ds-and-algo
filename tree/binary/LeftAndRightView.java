package tree.binary;

import tree.Node;
import tree.util.Util;

import java.util.LinkedList;
import java.util.Queue;

class LeftAndRightView {
    static int maxSoFar;
    static LinkedList<Node> leftViewForSoln2;
    static LinkedList<Node> rightViewForSoln2;

    public static void main(String[] args) {
        LeftAndRightView l = new LeftAndRightView();

        System.out.println("Left view : ");
        LinkedList<Node> leftViewOfT1 = l.leftView(Util.getBinaryTreeVariant1());
        leftViewOfT1.forEach(System.out::println);
        System.out.println("---");
        LinkedList<Node> leftViewOfT2 = l.leftView(Util.getCompleteBinaryTree());
        leftViewOfT2.forEach(System.out::println);
        System.out.println("---");

        //----------

        LinkedList<Node> leftViewOfT3 = l.leftViewRecursive(Util.getBinaryTreeVariant1());
        leftViewOfT3.forEach(System.out::println);
        System.out.println("---");
        LinkedList<Node> leftViewOfT4 = l.leftViewRecursive(Util.getCompleteBinaryTree());
        leftViewOfT4.forEach(System.out::println);
        System.out.println("---");

        System.out.println("Right view : ");
        LinkedList<Node> rightViewOfT1 = l.rightViewRecursive(Util.getBinaryTreeVariant1());
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
}

