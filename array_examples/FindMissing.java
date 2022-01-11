package array_examples;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

class FindMissing {
    public static void main(String[] args) {
        ArrayUtil.print(findMissing(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        ArrayUtil.print(findMissing(new int[]{1, 1, 2}));
        ArrayUtil.print(findMissing(new int[]{1}));
    }

    public static List<Integer> findMissing(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (index < 0) index *= -1;
            index -= 1;

            if (nums[index] > 0) nums[index] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) arr.add(i + 1);
        }

        return arr;
    }
}

