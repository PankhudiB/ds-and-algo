package array_examples;

import java.util.Arrays;

class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println("expected : 4 | got : " + findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}) + " for : 1,0,1,1,0");
        System.out.println("expected : 5 | got : " + findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 0, 1, 1, 1, 1}) + " for : 1,0,1,1,0,0,1,1,1,1");
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int maxOnesPossible = 0;
        int lastBit = -1;
        int lastZeroFlippedAt = -1;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr == 1) {
                maxOnesPossible++;
            } else {
                if (lastBit == -1) {
                    maxOnesPossible++;
                } else {
                    maxOnesPossible = i - lastZeroFlippedAt;
                }
                lastZeroFlippedAt = i;
            }
            lastBit = curr;
            max = Math.max(maxOnesPossible, max);
        }
        return max;
    }
}