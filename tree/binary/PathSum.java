package tree.binary;

import tree.Node;

class PathSum {
    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node8 = new Node(8);
        Node node11 = new Node(11);
        Node node13 = new Node(13);
        Node node4_ = new Node(4);
        Node node7 = new Node(7);
        Node node2 = new Node(2);
        Node node1 = new Node(1);

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

        PathSum c = new PathSum();
        System.out.println("hasPathSum :" + c.hasPathSum(node5,22));
    }

    public boolean hasPathSum(Node root, int targetSum) {
        return hasSum(root,targetSum,0);
    }

    private boolean hasSum(Node root, int targetSum, int sumSoFar){
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum == root.val+sumSoFar) return true;
        else {
            sumSoFar += root.val;
            return hasSum(root.left,targetSum, sumSoFar) || hasSum(root.right,targetSum,sumSoFar);
        }

    }
}
