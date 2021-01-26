package tree.binary;

import tree.Node;
import tree.Traversal;


class ConstructBinaryTreeFromPreorderInorder {
    static int preIndex = 0;

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        ConstructBinaryTreeFromPreorderInorder c = new ConstructBinaryTreeFromPreorderInorder();
        Node head = c.treeFromPreorderInorder(preOrder, inOrder, 0, inOrder.length - 1);
        Traversal traversal = new Traversal();
        traversal.levelOrderWithoutQueue(head);
    }

    Node treeFromPreorderInorder(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        Node node = new Node(preOrder[preIndex++]);
        if (inStart == inEnd) return node;

        int inIndex = searchFromInorder(inStart, inEnd, inOrder, node.val);
        node.left = treeFromPreorderInorder(preOrder, inOrder, inStart, inIndex - 1);
        node.right = treeFromPreorderInorder(preOrder, inOrder, inIndex + 1, inEnd);
        return node;
    }

    int searchFromInorder(int inStart, int inEnd, int[] inOrder, int data) {
        for (int i = inStart; i < inEnd; i++) {
            if (inOrder[i] == data) return i;
        }
        return -1;
    }
}

