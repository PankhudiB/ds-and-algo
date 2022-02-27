package tree.binary;

import tree.Node;

class CountUniValTrees {
    int count = 0;

    public static void main(String[] args) {
        Node node51 = new Node(5);
        Node node1 = new Node(1);
        Node node52 = new Node(5);
        Node node53 = new Node(5);
        Node node54 = new Node(5);
        Node node55 = new Node(5);

//                  5
//                /   \
//               1     5
//              / \      \
//             5  5       5

        node51.left = node1;
        node51.right = node52;
        node1.left = node53;
        node1.right = node54;
        node52.left = node55;

        CountUniValTrees c = new CountUniValTrees();
        System.out.println("countUnivalSubtrees :" + c.countUnivalSubtrees(node51));
    }

    public int countUnivalSubtrees(Node root) {
        if (root == null) return 0;
        isUni(root);
        return count;
    }

    private boolean isUni(Node root) {
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        boolean isUnival = true;
        if (root.left != null) {
            isUnival = isUni(root.left) && isUnival && root.val == root.left.val;
        }
        if (root.right != null) {
            isUnival = isUni(root.right) && isUnival && root.val == root.right.val;
        }
        if (!isUnival) return false;
        count++;
        return true;
    }
}
