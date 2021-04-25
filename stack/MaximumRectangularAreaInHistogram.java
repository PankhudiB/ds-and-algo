package stack;

public class MaximumRectangularAreaInHistogram {

    public static void main(String[] args) {
        System.out.println("7, 2, 8, 9, 1, 3, 6, 5 - maxAreaInHisto : " + maxAreaInHistogram(new int[]{7, 2, 8, 9, 1, 3, 6, 5}));
        System.out.println("7, 2, 8, 9, 1, 3, 6, 5 - maxAreaInHisto : " + maxAreaInHistogram(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }

    private static long maxAreaInHistogram(int[] histogram) {
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
}
