package array_examples;

import java.util.Arrays;

class HeightChecker {
    public static void main(String[] args) {
        System.out.println("expected : 3 | got : " + removeElement(new int[]{3, 2, 2, 3}));

    }

    public static int removeElement(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int incorrectCount = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) incorrectCount++;
        }
        return incorrectCount;
    }
}