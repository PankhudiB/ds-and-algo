package tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

class CheckIfSymmetric {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2l = new TreeNode(2);
        TreeNode node2r = new TreeNode(2);
        TreeNode node2l3 = new TreeNode(3);
        TreeNode node2l4 = new TreeNode(4);
        TreeNode node2r3 = new TreeNode(4);
        TreeNode node2r4 = new TreeNode(3);

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

    public static boolean isSymmetric(TreeNode head) {
        if (head == null) {
            return true;
        }
        return isSymmetric(head.left, head.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
