package tree.binary;

import linked_list.doubly.DListNode;
import tree.Node;

class ConvertToDLL {
    Node dllHead;

    public static void main(String[] args) {
        ConvertToDLL l = new ConvertToDLL();

        Node dll1 = l.convertToDLL(l.getBinaryTreeVariant1());
        l.forwardAndBackward(dll1);
        System.out.println("\n-------------------------");

        l.forwardAndBackward(l.convertToDLL(l.getCompleteBinaryTree()));
        System.out.println("\n-------------------------");

    }

    public Node convertToDLL(Node root) {
        dllHead = new Node(-1);
        Node headOfDLL = dllHead;
        inorder(root);
        headOfDLL = headOfDLL.right;
        headOfDLL.left = null;
        return headOfDLL;
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        dllHead.right = node;
        node.left = dllHead;
        dllHead = dllHead.right;
        inorder(node.right);
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

    public void forwardAndBackward(Node node) {
        System.out.println("forward");
        Node tail = node;
        while (node != null) {
            System.out.print(node.val + " --> ");
            tail = node;
            node = node.right;
        }

        System.out.println("\nbackward");
        while (tail != null) {
            System.out.print(tail.val + " --> ");
            tail = tail.left;
        }
    }
}

