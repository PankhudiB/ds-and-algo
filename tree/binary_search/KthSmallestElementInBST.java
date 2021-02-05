package tree.binary_search;

import tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class KthSmallestElementInBST {

    public static void main(String[] args) {
        Node bstHead = getBSTVariant1();
        KthSmallestElementInBST c = new KthSmallestElementInBST();
        System.out.println("kthSmallestElementInBST :" + c.kthSmallestElementInBST(bstHead, 3));

        Node anotherBst = getBSTVariant2();
        System.out.println("kthSmallestElementInBST :" + c.kthSmallestElementInBST(anotherBst, 1));

        System.out.println("kthSmallestElementInBST UsingInorderIterative :" + c.kthSmallestElementInBSTUsingInorderIterative(anotherBst, 1));
    }

    private static Node getBSTVariant2() {
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

//                  4
//                /   \
//               2     5
//                \
//                 3

        node4.left = node2;
        node4.right = node5;
        node2.right = node3;
        return node4;
    }

    private static Node getBSTVariant1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

//                  5
//                /   \
//               3     6
//              / \
//             2   4
//            /
//           1
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;
        return node5;
    }

    public int kthSmallestElementInBST(Node head, int k) {
        ArrayList<Integer> inorderTraversal = new ArrayList<>();
        inorder(head, inorderTraversal);
        return inorderTraversal.get(k - 1);
    }

    private void inorder(Node node, ArrayList<Integer> inorderTraversal) {
        if (node == null) return;
        inorder(node.left, inorderTraversal);
        inorderTraversal.add(node.val);
        inorder(node.right, inorderTraversal);
    }

    public int kthSmallestElementInBSTUsingInorderIterative(Node head, int k) {
        return inorderIterative(head, k);
    }

    private int inorderIterative(Node head, int k) {
        Node curr = head;
        Stack<Node> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (--k == 0) return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}
