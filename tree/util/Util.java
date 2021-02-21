package tree.util;

import tree.Node;

public class Util {
    public static Node getCompleteBinaryTree() {
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

    public static Node getBinaryTreeVariant1() {
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

    public static Node getBigBinaryTreeVariant1() {
//                       1
//                    /     \
//                   2        3
//                         /    \
//                       4        5
//                     /        /   \
//                    6        7      8
//                  /   \           /   \
//                9      10       11     12

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        node4.left = node6;

        node5.left = node7;
        node5.right = node8;

        node6.left = node9;
        node6.right = node10;

        node8.left = node11;
        node8.right = node12;

        return node1;
    }
}