package tree;

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

class TreeTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println("InOrder");
        printInOrder(node1);
        System.out.println();

        System.out.println("PreOrder");
        printPreOrder(node1);
        System.out.println();

        System.out.println("PostOrder");
        printPostOrder(node1);
        System.out.println();
    }

    public static void printInOrder(TreeNode head) {
        if (head == null){
            return;
        }
        printInOrder(head.left);
        System.out.print(head.val + "-");
        printInOrder(head.right);
    }

    public static void printPreOrder(TreeNode head) {
        if (head == null){
            return;
        }
        System.out.print(head.val + "-");
        printPreOrder(head.left);
        printPreOrder(head.right);
    }

    public static void printPostOrder(TreeNode head) {
        if (head == null){
            return;
        }
        printPostOrder(head.left);
        printPostOrder(head.right);
        System.out.print(head.val + "-");
    }
}
