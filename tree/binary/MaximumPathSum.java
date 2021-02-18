package tree.binary;

import tree.Node;

import java.util.*;

class MaximumPathSum {
    int maxPathSum;

    class Res {
        public int val;
    }

    public static void main(String[] args) {
        MaximumPathSum l = new MaximumPathSum();
        System.out.println("Maximum Path Sum is : " + l.maxPathSum(l.getBinaryTreeVariant1()));
        System.out.println("Maximum Path Sum is : " + l.maxPathSum(l.getBinaryTreeVariant2()));
        System.out.println("Maximum Path Sum is : " + l.maxPathSum(l.getBinaryTreeVariant3()));

        System.out.println("Maximum Path Sum is : " + l.pathSumConsideringNonZeroAsMaxPathSumOuterFunc(l.getBinaryTreeVariant1()));
        System.out.println("Maximum Path Sum is : " + l.pathSumConsideringNonZeroAsMaxPathSumOuterFunc(l.getBinaryTreeVariant2()));
        System.out.println("Maximum Path Sum is : " + l.pathSumConsideringNonZeroAsMaxPathSumOuterFunc(l.getBinaryTreeVariant3()));
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

//                    10
//                 /      \
//                 8        2
//              /    \
//            3       5

    public int pathSumConsideringNonZeroAsMaxPathSumOuterFunc(Node node) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        pathSumConsideringNonZeroAsMaxPathSum(node, res);
        return res.val;
    }

    public int pathSumConsideringNonZeroAsMaxPathSum(Node node, Res res) {
        if (node == null) return 0;

        // l and r store maximum path sum going through left and
        // right child of root respectively
        int left = pathSumConsideringNonZeroAsMaxPathSum(node.left, res);              //leaf level -> 3 or 5
        int right = pathSumConsideringNonZeroAsMaxPathSum(node.right, res);

        int maxConsiderEitherChild = Math.max(Math.max(left, right) + node.val, node.val);  // consider either root is sufficient or 8--5 link will get select here --> 13
        int maxConsideringRootInvolved = Math.max(maxConsiderEitherChild, left + node.val + right);   // 13 (8--5) v/s 16 (3--8--5)
        res.val = Math.max(maxConsiderEitherChild, maxConsideringRootInvolved);
        return maxConsiderEitherChild;      // while returning -> return maxConsiderEitherChild (13) and not 16 -- in the hope of finding bigger path upwards
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

