package recursion;

class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;

        if ((low != null && node.val <= low) || (high != null && node.val >= high)) return false;
        return helper(node.left, low, node.val) && helper(node.right, node.val, high);
    }
}