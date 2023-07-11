package array_examples;

public class FindFirstMissingPositiveNumber {
    public static void main(String[] args) {
        FindFirstMissingPositiveNumber f = new FindFirstMissingPositiveNumber();
        System.out.println(f.firstMissingPositive(new int[]{3, 4, -1, 1})); //ans -> 2
        System.out.println(f.firstMissingPositive(new int[]{7, 8, 9, 11})); //ans -> 1
        System.out.println(f.firstMissingPositive(new int[]{2, 1, 0})); //ans -> 3

    }

    public int firstMissingPositive(int[] nums) {
        boolean isOnePresent = false;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                isOnePresent = true;
            }
        }
        if (!isOnePresent) return 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int newIndex = Math.abs(nums[i]);
            if (newIndex == n) {
                nums[0] = -1 * Math.abs(nums[0]);
            } else {
                nums[newIndex] = -1 * Math.abs(nums[newIndex]);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }
}
