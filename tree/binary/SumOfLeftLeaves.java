package tree.binary;

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

class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_ = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);

//                  5
//                /   \
//               4     8
//              / \   /  \
//             11    13   4
//            /  \         \
//            7   2         1

        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node8.left = node13;
        node8.right = node4_;
        node11.left = node7;
        node11.right = node2;
        node4_.right = node1;

        SumOfLeftLeaves c = new SumOfLeftLeaves();
        System.out.println("sumOfLeftLeaves :" + c.sumOfLeftLeaves(node5));

        System.out.println("sumOfLeftLeavesMorris :" + c.sumOfLeftLeavesMorris(node5));
    }

    int sum = 0;

    //recursive - TC - O(N)  | SC - O(N)
    public int sumOfLeftLeaves(TreeNode root) {
        util(false, root);
        return sum;
    }

    private void util(boolean isLeft, TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null && isLeft) {
            sum = sum + node.val;
            return;
        }
        util(true, node.left);
        util(false, node.right);
    }

    //morris traversal - TC - O(N)  | SC - O(1)
    public int sumOfLeftLeavesMorris(TreeNode root) {
        int total = 0;
        TreeNode currNode = root;

        while (currNode != null) {
            if (currNode.left == null) {
                currNode = currNode.right;
            } else {
                TreeNode predecessor = currNode.left;
                if (predecessor.left == null && predecessor.right == null) {
                    total += predecessor.val;
                }
                while (predecessor.right != null && predecessor.right != currNode) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = currNode;
                    currNode = currNode.left;
                } else {
                    predecessor.right = null;
                    currNode = currNode.right;
                }
            }
        }
        return total;
    }
}
