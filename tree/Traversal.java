package tree;

import java.util.*;

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

        Traversal traversal = new Traversal();

        System.out.println("depth: " + traversal.depth(node1));

        System.out.println("InOrder");
        traversal.inOrder(node1);
        System.out.println();

        System.out.println("InOrder without Recursion");
        traversal.inOrderWithoutRecursion(node1);
        System.out.println();

        System.out.println("Inorder Morris traversal");
        traversal.morrisInorder(node1);
        System.out.println();

        System.out.println("PreOrder");
        traversal.preOrder(node1);
        System.out.println();

        System.out.println("PreOrder without Recur");
        traversal.preOrderWithoutRecursion(node1);
        System.out.println();


        System.out.println("Preorder Morris traversal");
        traversal.morrisPreorder(node1);
        System.out.println();

        System.out.println("PostOrder");
        traversal.postOrder(node1);
        System.out.println();

        System.out.println("PostOrder without recursion");
        traversal.postOrderWithoutRecursion(node1);
        System.out.println();


        System.out.println("LevelOrder");
        traversal.levelOrderWithoutQueue(node1);
        System.out.println();

        System.out.println("LevelOrder Using Queue");
        traversal.levelOrderUsingQueue(node1);
        System.out.println();

        System.out.println("Zigzag LevelOrder");
        traversal.zigzagLevelOrder(node1);
        System.out.println();
    }

    public void inOrder(Node head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.val + "=");
        inOrder(head.right);
    }

    void inOrderWithoutRecursion(Node head) {
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

    void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + "=");
        preOrder(head.left);
        preOrder(head.right);
    }

    void preOrderWithoutRecursion(Node head) {
        Stack<Node> stack = new Stack<>();
        List<Integer> l = new ArrayList<>();
        if (head != null) stack.add(head);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.val + " ");
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    public void postOrder(Node head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val + "=");
    }

    public void postOrderWithoutRecursion(Node head) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (head != null) s1.add(head);

        while (!s1.isEmpty()) {
            Node curr = s1.pop();
            s2.push(curr);
            if (curr.left != null) s1.push(curr.left);
            if (curr.right != null) s1.push(curr.right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + " ");
        }
    }


    public void levelOrderWithoutQueue(Node head) {
        int depth = depth(head);
        for (int i = 0; i <= depth; i++) {
            printGivenLevel(head, i);
        }
    }

    private void printGivenLevel(Node node, int level) {
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

    public int depth(Node head) {
        if (head == null) {
            return 0;
        }
        int leftDepth = depth(head.left) + 1;
        int rightDepth = depth(head.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    void levelOrderUsingQueue(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.val + "=");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    List<List<Integer>> zigzagLevelOrder(Node head) {
        if (head == null) {
            return new LinkedList<>();
        }
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        currLevel.push(head);
        boolean printRightToLeft = true;
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> currList = new LinkedList<Integer>();

        while (!currLevel.isEmpty()) {
            Node popped = currLevel.pop();
            currList.add(popped.val);

            if (printRightToLeft) {
                if (popped.left != null) nextLevel.push(popped.left);
                if (popped.right != null) nextLevel.push(popped.right);
            } else {
                if (popped.right != null) nextLevel.push(popped.right);
                if (popped.left != null) nextLevel.push(popped.left);
            }

            if (currLevel.isEmpty()) {
                printRightToLeft = !printRightToLeft;
                result.add(currList);
                Stack<Node> temp = currLevel;
                currLevel = nextLevel;
                nextLevel = temp;
                currList = new LinkedList<Integer>();
            }
        }
        return result;
    }

    void morrisInorder(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + "=");
                curr = curr.right;
            } else {
                Node predecessor = curr.left;
                while (predecessor.right != curr && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    System.out.print(curr.val + "=");
                    curr = curr.right;
                }
            }
        }
    }

    void morrisPreorder(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + "=");
                curr = curr.right;
            } else {
                Node predecessor = curr.left;
                while (predecessor.right != curr && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    System.out.print(curr.val + "=");
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    curr = curr.right;
                }
            }
        }
    }
}
