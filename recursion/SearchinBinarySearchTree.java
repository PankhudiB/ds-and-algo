package recursion;


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return helper(root, val);
    }

    TreeNode helper(TreeNode root, int val) {
        if (root == null || val == root.val) return root;

        if (val > root.val) {
            return helper(root.right, val);
        } else {
            return helper(root.left, val);
        }

    }

    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null && val != root.val)
            root = val < root.val ? root.left : root.right;
        return root;
    }
}