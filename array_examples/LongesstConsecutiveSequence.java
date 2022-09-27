package array_examples;

import java.util.Arrays;

class LongesstConsecutiveSequence {
    public static void main(String[] args) {
        LongesstConsecutiveSequence l = new LongesstConsecutiveSequence();

        System.out.println(l.longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));

        System.out.println(l.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int longestStreak = 0;
        int streakSoFar = 0;
        if (n == 0 || n == 1) return n;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i - 1] + 1 == nums[i]) {
                streakSoFar++;
                // i++;
            } else {
                longestStreak = Math.max(longestStreak, (streakSoFar + 1));
                streakSoFar = 0;
            }
        }
        longestStreak = Math.max(longestStreak, (streakSoFar + 1));
        return longestStreak;
    }

}

