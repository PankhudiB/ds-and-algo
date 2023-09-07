package tree.binary_search;


import tree.Node;
import tree.Traversal;
import tree.binary.TreeNode;

public class ConvertBSTToGreaterTree {
    int sumSoFar = 0;

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node4.left = node1;
        node4.right = node6;
        node1.left = node0;
        node1.right = node2;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        node7.right = node8;

        Traversal t = new Traversal();
        t.inOrder(node4);
        ConvertBSTToGreaterTree c = new ConvertBSTToGreaterTree();
        c.convert(node4);
        System.out.println();
        t.inOrder(node4);
    }

    private void convert(Node root) {
        reverseInorder(root);
    }

    private void reverseInorder(Node curr) {
        if (curr == null) return;

        reverseInorder(curr.right);
        int temp = curr.val;
        curr.val += this.sumSoFar;
        this.sumSoFar += temp;
        reverseInorder(curr.left);
    }
}
