package array_examples;

import java.util.Arrays;

class LongesstConsecutiveSequence {
    public static void main(String[] args) {
        LongesstConsecutiveSequence l = new LongesstConsecutiveSequence();

        System.out.println(l.longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
        System.out.println(l.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println("----------------------");
        System.out.println(l.longestConsecutiveBruteForce(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
        System.out.println(l.longestConsecutiveBruteForce(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println("----------------------");
    }

    //sort
    // compare with previous element
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

    // brute force
    // n^3 solution
    // for each number
    //        while loop from number to ... number+1, number+2, number+3 ...
    //        until - u dont find the sub sequent no in input array

    public int longestConsecutiveBruteForce(int[] nums) {
        int n = nums.length;
        int longestStreak = 0;
        int streakSoFar = 0;
        if (n == 0 || n == 1) return n;

        for (int i = 0; i < nums.length; i++) {
            streakSoFar = 1;
            int current = nums[i];

            while (arrayContains(nums, current + 1)) {
                current = current + 1;
                streakSoFar++;
            }
            longestStreak = Math.max(longestStreak, streakSoFar);
        }
        return longestStreak;
    }

    private boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
}

