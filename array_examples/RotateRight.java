package array_examples;

import util.ArrayUtil;

class RotateRight {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        ArrayUtil.print(arr1);
        int[] shiftedRight = rotate(arr1, 3);
        ArrayUtil.print(shiftedRight);


        int[] arr2 = {1, 2};
        ArrayUtil.print(arr2);
        int[] shiftedRight2 = rotate(arr2, 1);
        ArrayUtil.print(shiftedRight2);

        int[] arr3 = {1, 2};
        ArrayUtil.print(arr3);
        int[] shiftedRight3 = rotate(arr3, 2);
        ArrayUtil.print(shiftedRight3);

    }

    public static int[] rotate(int[] nums, int k) {
        k %= nums.length;
        int temp, previous;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            previous = nums[n - 1];
            for (int j = 0; j < n; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        return nums;
    }

    public static int[] rotateUsingExtraSpace(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
        return nums;
    }
}

