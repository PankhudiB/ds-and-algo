package dp;

public class MaxSubArray_usingDP {

    public static void main(String[] args) {
        MaxSubArray_usingDP s = new MaxSubArray_usingDP();

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(s.maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max = nums[0];
        int maxSoFar = nums[0];
        for (int i = 0; i < nums.length; i++) {
            maxSoFar = Math.max(nums[i], (maxSoFar + nums[i]));
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}
