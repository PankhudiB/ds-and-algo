package stack;

import java.util.Stack;

public class MaximumRectangularAreaInHistogram {

    public static void main(String[] args) {
        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_firstIntuitiveSoln(new int[]{7, 2, 8, 9, 1, 3, 6, 5}));
        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_firstIntuitiveSoln(new int[]{6, 2, 5, 4, 5, 1, 6}));

        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_Bruteforce(new int[]{7, 2, 8, 9, 1, 3, 6, 5}));
        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_Bruteforce(new int[]{6, 2, 5, 4, 5, 1, 6}));

        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_BetterBruteforce(new int[]{7, 2, 8, 9, 1, 3, 6, 5}));
        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_BetterBruteforce(new int[]{6, 2, 5, 4, 5, 1, 6}));

        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_OOfN(new int[]{7, 2, 8, 9, 1, 3, 6, 5}));
        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_OOfN(new int[]{6, 2, 5, 4, 5, 1, 6}));
        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_OOfN(new int[]{2, 3}));
    }

    private static long maxAreaInHistogram_firstIntuitiveSoln(int[] histogram) {
        long maxArea = 0;
        for (int i = 0; i < histogram.length; i++) {
            int tilesCoverage = 1;
            for (int back = i - 1; back >= 0; back--) {
                if (histogram[back] < histogram[i]) break;
                tilesCoverage++;
            }
            for (int fwd = i + 1; fwd < histogram.length; fwd++) {
                if (histogram[fwd] < histogram[i]) break;
                tilesCoverage++;
            }
            maxArea = Math.max(maxArea, tilesCoverage * histogram[i]);
        }
        return maxArea;
    }

    private static long maxAreaInHistogram_Bruteforce(int[] histogram) {
        long maxArea = 0;
        for (int i = 0; i < histogram.length; i++) {
            for (int j = i; j < histogram.length; j++) {
                long minHeight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, histogram[k]);
                }
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    private static long maxAreaInHistogram_BetterBruteforce(int[] histogram) {
        long maxArea = 0;
        for (int i = 0; i < histogram.length; i++) {
            long minHeight = Integer.MAX_VALUE;
            for (int j = i; j < histogram.length; j++) {
                minHeight = Math.min(minHeight, histogram[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    private static int maxAreaInHistogram_OOfN(int[] histogram) {
        int maxArea = 0;
        int n = histogram.length;

        int[] left = nearestLeftBarWithLowerHeight(histogram, n);
        int[] right = nearestRightBarWithLowerHeight(histogram, n);

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * histogram[i]);
        }
        return maxArea;
    }

    private static int[] nearestLeftBarWithLowerHeight(int[] histogram, int n) {
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                left[i] = 0;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
                stack.push(i);
            }
        }
        return left;
    }

    private static int[] nearestRightBarWithLowerHeight(int[] histogram, int n) {
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                right[i] = n - 1;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
                stack.push(i);
            }
        }
        return right;
    }


}
