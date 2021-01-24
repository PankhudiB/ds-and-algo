package tree.binary;

import tree.Node;

class CheckIfSymmetric {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2l = new Node(2);
        Node node2r = new Node(2);
        Node node2l3 = new Node(3);
        Node node2l4 = new Node(4);
        Node node2r3 = new Node(4);
        Node node2r4 = new Node(3);

//                  1
//                /   \
//               2     2
//              / \   / \
//             3   4  4   3
        node1.left = node2l;
        node1.right = node2r;
        node2l.left = node2l3;
        node2l.right = node2l4;
        node2r.left = node2r3;
        node2r.right = node2r4;

        System.out.println("isSymmetric :" + isSymmetric(node1));
    }

    public static boolean isSymmetric(Node head) {
        if (head == null) {
            return true;
        }
        return isSymmetric(head.left, head.right);
    }

    private static boolean isSymmetric(Node left, Node right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
