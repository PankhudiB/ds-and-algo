package tree.binary;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

class IsIdentical {

    public static void main(String[] args) {
        IsIdentical l = new IsIdentical();
        System.out.println(l.isIdentical(l.getBinaryTreeVariant1(), l.getBinaryTreeVariant2()));
    }

    public boolean isIdentical(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        else if (n1 == null || n2 == null) return false;
        return (n1.val != n2.val) && isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right);
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

    private static Node getBinaryTreeVariant2() {
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node15 = new Node(15);
        Node node20 = new Node(20);
        Node node3 = new Node(3);
//        Node node8 = new Node(8);

        node10.left = node9;
        node10.right = node20;
        node20.left = node15;
        node20.right = node7;
        node15.right = node3;
//        node7.left = node8;

        return node10;
    }
}

