package tree.binary;

import tree.Node;

class Tuple<T, U> {
    public final T currDepth;
    public final U maxChainLength;

    public Tuple(T currDepth, U maxChainLength) {
        this.currDepth = currDepth;
        this.maxChainLength = maxChainLength;
    }
}

class LengthOFLongestChain {
    public static void main(String[] args) {
        LengthOFLongestChain l = new LengthOFLongestChain();
        Node variant1Head = l.getBinaryTreeVariant1();
        System.out.println("longest chain length :" + l.longestChain(variant1Head));

        Node variant2Head = l.getBinaryTreeVariant2();
        System.out.println("longest chain length :" + l.longestChain(variant2Head));
    }

    private Node getBinaryTreeVariant2() {
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

    private Node getBinaryTreeVariant1() {
//                  1
//            2          3
//        4       5   6     7
//     8     9

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        return node1;
    }

    public int longestChain(Node head) {
        return maxChainLength(head).maxChainLength;
    }

    private Tuple<Integer, Integer> maxChainLength(Node head) {
        if (head == null) {
            return new Tuple<Integer, Integer>(0, 0);
        }
        Tuple<Integer, Integer> left = maxChainLength(head.left);
        Tuple<Integer, Integer> right = maxChainLength(head.right);
        Integer currDepth = Math.max(left.currDepth, right.currDepth) + 1;
        Integer currChainLength = left.currDepth + right.currDepth + 1;
        Integer maxChainSoFar = Math.max(currChainLength, Math.max(left.maxChainLength, right.maxChainLength));
        return new Tuple<Integer, Integer>(currDepth, maxChainSoFar);
    }
}

