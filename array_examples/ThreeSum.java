package array_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public static void main(String[] args) {
        //TARGET IS ALWAYS ZERO
        threeSum(new int[]{-1, 0, 1, 2, -1, -4}, 0);

        threeSum(new int[]{-2, 0, 0, 2, 2}, 0);

    }

    // -1, 0, 1, 2, -1, -4
    // -4, -1, -1, 0, 1, 2
    //
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];

                if (sum == 0) {
                    solutions.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }


                } else {
                    if (sum < 0) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return solutions;
    }
}

