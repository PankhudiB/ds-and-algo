package tree;

class SortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] sortedArr = new int[]{-10, -3, 0, 5, 9};
        TreeNode head = sortedArrayToBinarySearchTree(sortedArr);
        TreeTraversal.printInOrder(head);
    }

    public static TreeNode sortedArrayToBinarySearchTree(int[] arr) {
        if (arr.length == 0) return null;
        return sortedArrayToBinarySearchTree(arr, 0, arr.length - 1);
    }

    private static TreeNode sortedArrayToBinarySearchTree(int[] arr, int start, int end) {
        if (start > end) return null;
        int middle = start + ((end - start) / 2);
        TreeNode middleNode = new TreeNode(arr[middle]);
        middleNode.left = sortedArrayToBinarySearchTree(arr, start, middle - 1);
        middleNode.right = sortedArrayToBinarySearchTree(arr, middle + 1, end);
        return middleNode;
    }

}