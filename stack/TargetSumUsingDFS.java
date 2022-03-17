package stack;

public class TargetSumUsingDFS {
    static int result = 0;

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(findTargetSumWays(new int[]{1}, 1));
        System.out.println(findTargetSumWays(new int[]{1, 1, 1}, 2));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        result = 0;
        calculate(nums, 0, 0, target);
        return result;
    }

    private static void calculate(int[] nums, int sumSoFar, int ith, int target) {
        if (ith == nums.length && sumSoFar == target) {
            result++;
            return;
        }
        if (ith > nums.length - 1) {
            return;
        }
        int sumSoFarPosibility1 = sumSoFar + nums[ith];
        int sumSoFarPosibility2 = sumSoFar + nums[ith] * -1;
        ith++;
        calculate(nums, sumSoFarPosibility1, ith, target);
        calculate(nums, sumSoFarPosibility2, ith, target);
    }
}