package tree.binary_search;

import tree.Node;
import tree.Traversal;

class SortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        SortedArrayToBinarySearchTree s = new SortedArrayToBinarySearchTree();
        int[] sortedArr = new int[]{-10, -3, 0, 5, 9};
        Node head = s.sortedArrayToBinarySearchTree(sortedArr);
        Traversal traversal = new Traversal();
        traversal.inOrder(head);
    }

    public Node sortedArrayToBinarySearchTree(int[] arr) {
        if (arr.length == 0) return null;
        return sortedArrayToBinarySearchTree(arr, 0, arr.length - 1);
    }

    private Node sortedArrayToBinarySearchTree(int[] arr, int start, int end) {
        if (start > end) return null;
        int middle = start + ((end - start) / 2);
        Node middleNode = new Node(arr[middle]);
        middleNode.left = sortedArrayToBinarySearchTree(arr, start, middle - 1);
        middleNode.right = sortedArrayToBinarySearchTree(arr, middle + 1, end);
        return middleNode;
    }

}