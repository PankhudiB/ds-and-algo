package array_examples;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

class SquaresOfSortedArray {
    public static void main(String[] args) {
        ArrayUtil.print(squaresOfSorted(new int[]{-5, -3, -2, -1}));
        ArrayUtil.print(squaresOfSorted(new int[]{-7, -3, 2, 3, 11}));
    }

    public static int[] squaresOfSorted(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int square = 0;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}

