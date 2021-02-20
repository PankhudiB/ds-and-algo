package tree.binary;

import tree.Node;

import java.util.*;
import java.util.Map;

class BottomView {
    Map<Integer, Integer> bottomView;

    public static void main(String[] args) {
        BottomView l = new BottomView();

        System.out.println("Bottom view : ");
        System.out.println(l.bottomView(l.getBinaryTreeVariant1()).values());
        System.out.println("---");

        System.out.println(l.bottomView(l.getCompleteBinaryTree()).values());
        System.out.println("---");
    }

    public Map<Integer, Integer> bottomView(Node root) {
        bottomView = new TreeMap<>();
        horizontalDistance(root, 0);
        return bottomView;
    }

    private void horizontalDistance(Node node, int horizontalDistance) {
        if (node == null) return;
        bottomView.put(horizontalDistance, node.val);
        if (node.left != null) horizontalDistance(node.left, horizontalDistance - 1);
        if (node.right != null) horizontalDistance(node.right, horizontalDistance + 1);
    }

    private Node getBinaryTreeVariant1() {
//                    10
//                 /     \
//                9        20
//                        /    \
//                     15      7
//                       \    /
//                         3 8

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

