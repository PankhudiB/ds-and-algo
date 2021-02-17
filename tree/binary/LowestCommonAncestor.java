package tree.binary;

import tree.Node;

class LowestCommonAncestor {
    private Node lca;

    LowestCommonAncestor() {
        this.lca = null;
    }

    public static void main(String[] args) {
        LowestCommonAncestor l = new LowestCommonAncestor();
        Node variant1Head = l.getBinaryTreeVariant1();
        Node node3 = variant1Head.right;
        Node node4 = variant1Head.right.left;
        Node node8 = variant1Head.right.right.right;


        System.out.println("Lowest common ancestor of 4 and 8 is :" + l.findLowestCommonAncestor(variant1Head, node4, node8));
        System.out.println("Lowest common ancestor is 3 nad 4 is :" + l.findLowestCommonAncestor(variant1Head, node4, node3));
    }

    public Node findLowestCommonAncestor(Node head, Node p, Node q) {
        hasDesiredNodes(head, p, q);
        return this.lca;
    }

    private boolean hasDesiredNodes(Node curr, Node p, Node q) {
        if (curr == null) return false;
        int left = hasDesiredNodes(curr.left, p, q) ? 1 : 0;
        int right = hasDesiredNodes(curr.right, p, q) ? 1 : 0;
        int mid = (curr == p || curr == q) ? 1 : 0;
        if (mid + left + right >= 2) this.lca = curr;
        return (mid + left + right > 0);
    }

    private Node getBinaryTreeVariant1() {
//                    1
//                 /      \
//                2         3
//                        /    \
//                     4         5
//                    /        /   \
//                   6        7     8
//                  / \           /   \
//                9    10       11     12

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        node4.left = node6;

        node5.left = node7;
        node5.right = node8;

        node6.left = node9;
        node6.right = node10;

        node8.left = node11;
        node8.right = node12;

        return node1;
    }
}

