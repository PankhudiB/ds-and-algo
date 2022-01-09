package array_examples;

import util.ArrayUtil;

class MoveZerosToTheEnd {
    public static void main(String[] args) {
        ArrayUtil.print(moveZeroes(new int[]{1, 0, 0, 1, 2}));
        ArrayUtil.print(moveZeroes(new int[]{0, 0, 1, 3, 0, 4, 0}));
    }

    public static int[] moveZeroes(int[] nums) {
        int first_zero_at = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && first_zero_at == -1) {
                first_zero_at = i;
            } else if (nums[i] != 0 && first_zero_at != -1) {
                nums[first_zero_at] = nums[i];
                nums[i] = 0;
                first_zero_at = first_zero_at + 1;
            }
        }
        return nums;
    }
}

