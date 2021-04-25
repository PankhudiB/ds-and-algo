package stack;

public class MaximumRectangularAreaInHistogram_Bruteforce {

    public static void main(String[] args) {
        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_firstIntuitiveSoln(new int[]{7, 2, 8, 9, 1, 3, 6, 5}));
        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_firstIntuitiveSoln(new int[]{6, 2, 5, 4, 5, 1, 6}));

        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_Bruteforce(new int[]{7, 2, 8, 9, 1, 3, 6, 5}));
        System.out.println("maxAreaInHisto : " + maxAreaInHistogram_Bruteforce(new int[]{6, 2, 5, 4, 5, 1, 6}));
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


}
