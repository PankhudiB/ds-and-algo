package array_examples;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class FindDuplicates {
    public static void main(String[] args) {
        ArrayUtil.print(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        ArrayUtil.print(findDuplicates(new int[]{1, 1, 2}));
        ArrayUtil.print(findDuplicates(new int[]{1}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (index < 0) index *= -1;
            index -= 1;
            if (nums[index] < 0) arr.add(index + 1);
            else nums[index] *= -1;
        }
        return arr;
    }
}

