package tree.binary;

import tree.Node;
import tree.Traversal;

import java.util.HashMap;
import java.util.HashSet;


class ConstructBinaryTreeFromPreorderInorder {
    static int preIndex = 0;
    static HashMap<Integer, Integer> valueToIndex = new HashMap<>();

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        buildValueToIndexMap(inOrder);
        Traversal traversal = new Traversal();

        ConstructBinaryTreeFromPreorderInorder c = new ConstructBinaryTreeFromPreorderInorder();
        Node head1 = c.treeFromPreorderInorder(preOrder, inOrder, 0, inOrder.length - 1);
        traversal.postOrder(head1);
        System.out.println();

        preIndex = 0;
        Node head2 = c.treeFromPreorderInorderUseHashMap(preOrder, inOrder, 0, inOrder.length - 1);
        traversal.postOrder(head2);
    }

    private static void buildValueToIndexMap(int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            valueToIndex.put(inOrder[i], i);
        }
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

    private int searchFromInorder(int inStart, int inEnd, int[] inOrder, int data) {
        for (int i = inStart; i < inEnd; i++) {
            if (inOrder[i] == data) return i;
        }
        return -1;
    }

    Node treeFromPreorderInorderUseHashMap(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        Node node = new Node(preOrder[preIndex++]);
        if (inStart == inEnd) return node;

        int inIndex = valueToIndex.get(node.val);
        node.left = treeFromPreorderInorder(preOrder, inOrder, inStart, inIndex - 1);
        node.right = treeFromPreorderInorder(preOrder, inOrder, inIndex + 1, inEnd);
        return node;
    }
}

