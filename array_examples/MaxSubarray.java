package array_examples;

public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int maxSoFar = 0;
        int max = nums[0];
        if (nums.length == 1) return nums[0];

        for (int num : nums) {
            maxSoFar = maxSoFar + num;
            max = Math.max(max, maxSoFar);
            if (maxSoFar < 0) {
                maxSoFar = 0;
            }
        }
        return max;
    }
}
