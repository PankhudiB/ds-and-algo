package tree.binary;

import tree.Node;
import tree.Traversal;

import java.util.LinkedList;
import java.util.Queue;

class LeftView {

    public static void main(String[] args) {
        LeftView l = new LeftView();

        LinkedList<Node> leftViewOfT1 = l.leftView(l.getBinaryTreeVariant1());
        leftViewOfT1.forEach(System.out::println);
        System.out.println("---");
        LinkedList<Node> leftViewOfT2 = l.leftView(l.getCompleteBinaryTree());
        leftViewOfT2.forEach(System.out::println);
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

    private Node getBinaryTreeVariant1() {
//                    10
//                 /      \
//                9         20
//                        /    \
//                      15      7
//                         \
//                           3

        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node15 = new Node(15);
        Node node20 = new Node(20);
        Node node3 = new Node(3);

        node10.left = node9;
        node10.right = node20;
        node20.left = node15;
        node20.right = node7;
        node15.right = node3;

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

