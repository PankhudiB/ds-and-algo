package array_examples;

public class FindConsecutiveOnes {
    public static void main(String[] args) {
        FindConsecutiveOnes f = new FindConsecutiveOnes();
        f.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1});
        f.findMaxConsecutiveOnes(new int[]{1, 0, 1, 0, 0, 1});
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        boolean usedZero = false;
        int max = 0;
        int maxSoFar = 0;
        int lastZeroSeenAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                maxSoFar++;
            } else if (nums[i] == 0 && !usedZero) {
                maxSoFar++;
                usedZero = true;
                lastZeroSeenAt = i;
            } else if (nums[i] == 0 && usedZero) {
                max = Math.max(max, maxSoFar);
                maxSoFar = i - lastZeroSeenAt;
                lastZeroSeenAt = i;
            }
        }

        return Math.max(max, maxSoFar);
    }
}
