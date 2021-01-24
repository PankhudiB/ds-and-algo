package tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return val + "";
    }
}

class TreeTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

//                  1
//            2          3
//        4       5
//                    6
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node6;

        System.out.println("depth: " + depth(node1));

        System.out.println("InOrder");
        printInOrder(node1);
        System.out.println();

        System.out.println("PreOrder");
        printPreOrder(node1);
        System.out.println();

        System.out.println("PostOrder");
        printPostOrder(node1);
        System.out.println();

        System.out.println("LevelOrder");
        printLevelOrderWithoutQueue(node1);
        System.out.println();

        System.out.println("LevelOrder Using Queue");
        printLevelOrderUsingQueue(node1);
        System.out.println();
    }

    public static void printInOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        printInOrder(head.left);
        System.out.print(head.val + "=");
        printInOrder(head.right);
    }

    public static void printPreOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + "=");
        printPreOrder(head.left);
        printPreOrder(head.right);
    }

    public static void printPostOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        printPostOrder(head.left);
        printPostOrder(head.right);
        System.out.print(head.val + "=");
    }

    public static void printLevelOrderWithoutQueue(TreeNode head) {
        int depth = depth(head);
        for (int i = 0; i <= depth; i++) {
            printGivenLevel(head, i);
        }
    }

    private static void printGivenLevel(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.val + "=");
        } else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }

    private static int depth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int leftDepth = depth(head.left) + 1;
        int rightDepth = depth(head.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    public static void printLevelOrderUsingQueue(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + "=");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }
}
