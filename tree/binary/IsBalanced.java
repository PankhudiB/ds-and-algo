package tree.binary;

import tree.Node;
import tree.util.Util;

class Height {
    int height;

    Height() {
        this.height = 0;
    }
}

class IsBalanced {

    public static void main(String[] args) {
        IsBalanced l = new IsBalanced();

        System.out.println(l.isBalanced(Util.getBinaryTreeVariant1()));
        System.out.println(l.isBalanced(l.getBinaryTreeVariant2()));
        System.out.println(l.isBalanced(Util.getCompleteBinaryTree()));

        Height height = new Height();
        System.out.println(l.isBalanced(Util.getBinaryTreeVariant1(), height));
        System.out.println(l.isBalanced(l.getBinaryTreeVariant2(), height));
        System.out.println(l.isBalanced(Util.getCompleteBinaryTree(), height));
    }

    public boolean isBalanced(Node node) {
        if (node == null) return true;
        int lh = height(node.left);
        int rh = height(node.right);
        return (Math.abs(lh - rh) <= 1) && isBalanced(node.left) && isBalanced(node.right);
    }

    public int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isBalanced(Node node, Height height) {
        if (node == null) {
            height.height = 0;
            return true;
        }
        Height lheight = new Height();
        Height rheight = new Height();
        boolean l = isBalanced(node.left, lheight);
        boolean r = isBalanced(node.right, rheight);
        int lh = lheight.height;
        int rh = rheight.height;

        height.height = 1 + Math.max(lh, rh);
        if (Math.abs(lh - rh) > 1) return false;
        else return l && r;
    }

    private static Node getBinaryTreeVariant2() {
//                    10
//                 /      \
//                9         20
//                        /    \
//                      15      7
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node15 = new Node(15);
        Node node20 = new Node(20);

        node10.left = node9;
        node10.right = node20;
        node20.left = node15;
        node20.right = node7;

        return node10;
    }
}

