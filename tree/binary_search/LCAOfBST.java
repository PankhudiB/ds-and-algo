package tree.binary_search;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LCAOfBST {
    public static void main(String[] args) {
        LCAOfBST l = new LCAOfBST();
    }

    // TC -> O(n) - at worst case u ll end up visiting all node in BST ... if its a skewed tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) {
            return helper(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return helper(root.right, p, q);
        }
        return root;
    }

    // iterative
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        int pVal = p.val;
        int qVal = q.val;

        while(current !=null ) {
            if(pVal < current.val && qVal < current.val )
                current = current.left;
            else if(pVal > current.val && qVal > current.val )
                current = current.right;
            else return current;
        }
        return null;
    }
}
