package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

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
        inOrder(node1);
        System.out.println();

        System.out.println("InOrder without Recursion");
        inOrderWithoutRecursion(node1);
        System.out.println();

        System.out.println("PreOrder");
        preOrder(node1);
        System.out.println();

        System.out.println("PostOrder");
        postOrder(node1);
        System.out.println();

        System.out.println("LevelOrder");
        levelOrderWithoutQueue(node1);
        System.out.println();

        System.out.println("LevelOrder Using Queue");
        levelOrderUsingQueue(node1);
        System.out.println();
    }

    public static void inOrder(Node head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.val + "=");
        inOrder(head.right);
    }

    public static void inOrderWithoutRecursion(Node head) {
        if (head == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + "=");
            curr = curr.right;
        }
    }

    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + "=");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void postOrder(Node head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val + "=");
    }

    public static void levelOrderWithoutQueue(Node head) {
        int depth = depth(head);
        for (int i = 0; i <= depth; i++) {
            printGivenLevel(head, i);
        }
    }

    private static void printGivenLevel(Node node, int level) {
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

    private static int depth(Node head) {
        if (head == null) {
            return 0;
        }
        int leftDepth = depth(head.left) + 1;
        int rightDepth = depth(head.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    public static void levelOrderUsingQueue(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.val + "=");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }
}
