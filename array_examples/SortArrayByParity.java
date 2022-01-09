package array_examples;

import util.ArrayUtil;

class SortArrayByParity {
    public static void main(String[] args) {
        ArrayUtil.print(sortArrayByParity(new int[]{3, 1, 2, 4}));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int firstOddAt = -1;
        int firstEvenAt = -1;

        for (int curr = 0; curr < nums.length; curr++) {
            if (nums[curr] % 2 == 0) {
                if (firstEvenAt == -1) firstEvenAt = curr;
                if (firstOddAt != -1) {
                    int temp = nums[firstOddAt];
                    nums[firstOddAt] = nums[curr];
                    nums[curr] = temp;
                    firstOddAt = firstOddAt + 1;
                }

            } else {
                if (firstOddAt == -1) firstOddAt = curr;
            }
        }
        return nums;
    }
}

