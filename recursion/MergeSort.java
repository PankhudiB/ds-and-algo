package recursion;

import java.util.Arrays;

class MergeSort {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }

    private int[] mergeSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int pivot = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, pivot));
        int[] right = mergeSort(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftCursor = 0, rightCursor = 0, curr = 0;
        while (leftCursor < left.length && rightCursor < right.length) {
            if (left[leftCursor] < right[rightCursor]) {
                result[curr] = left[leftCursor];
                leftCursor++;
            } else {
                result[curr] = right[rightCursor];
                rightCursor++;
            }
            curr++;
        }

        while (leftCursor < left.length) {
            result[curr++] = left[leftCursor++];
        }

        while (rightCursor < right.length) {
            result[curr++] = right[rightCursor++];
        }
        return result;
    }
}