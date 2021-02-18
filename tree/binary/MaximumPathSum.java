package tree.binary;

import tree.Node;

import java.util.*;

class MaximumPathSum {
    int maxPathSum;

    public static void main(String[] args) {
        MaximumPathSum l = new MaximumPathSum();
        System.out.println("Maximum Path Sum is : " + l.maxPathSum(l.getBinaryTreeVariant1()));
        System.out.println("Maximum Path Sum is : " + l.maxPathSum(l.getBinaryTreeVariant2()));
        System.out.println("Maximum Path Sum is : " + l.maxPathSum(l.getBinaryTreeVariant3()));
    }

    public int maxPathSum(Node root) {
        maxPathSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxPathSum;
    }

    public int pathSum(Node node) {
        if (node == null) return 0;
        int left = Math.max(pathSum(node.left), 0);
        int right = Math.max(pathSum(node.right), 0);
        maxPathSum = Math.max(maxPathSum, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    private Node getBinaryTreeVariant1() {
//                    10
//                 /      \
//                9         20
//                        /    \
//                      15      7

        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node15 = new Node(15);
        Node node20 = new Node(20);

        node10.left = node9;
        node10.right = node20;
        node20.left = node15;
        node20.right = node7;

        return node10;
    }

    private Node getBinaryTreeVariant2() {
//                    -10
//                 /      \
//                9         20
//                        /    \
//                      15      7

        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node nodeminus10 = new Node(-10);
        Node node15 = new Node(15);
        Node node20 = new Node(20);

        nodeminus10.left = node9;
        nodeminus10.right = node20;
        node20.left = node15;
        node20.right = node7;

        return nodeminus10;
    }

    private Node getBinaryTreeVariant3() {
//                    -10
//                 /      \
//               -9         -30
//                        /    \
//                      55      -2

        Node nodeminus10 = new Node(-10);
        Node nodeminus9 = new Node(-9);
        Node nodeminus30 = new Node(-30);
        Node node55 = new Node(55);
        Node nodeminus2 = new Node(-2);

        nodeminus10.left = nodeminus9;
        nodeminus10.right = nodeminus30;
        nodeminus30.left = node55;
        nodeminus30.right = nodeminus2;

        return nodeminus10;
    }
}

