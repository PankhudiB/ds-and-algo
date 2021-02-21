package tree.binary;

import tree.Node;
import tree.util.Util;

class IsIdentical {

    public static void main(String[] args) {
        IsIdentical l = new IsIdentical();

        System.out.println(l.isIdentical(Util.getBinaryTreeVariant1(), Util.getBinaryTreeVariant1()));
        System.out.println(l.isIdentical(Util.getBinaryTreeVariant1(), getBinaryTreeVariant2()));
    }

    public boolean isIdentical(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a != null && b != null)
            return (a.val == b.val
                    && isIdentical(a.left, b.left)
                    && isIdentical(a.right, b.right));
        return false;
    }

    private static Node getBinaryTreeVariant2() {
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
}

