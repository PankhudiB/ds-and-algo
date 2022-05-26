package binary_search;

public class FindIn2DMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 2}, {3, 4}}, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;
            int midElement = matrix[midpoint / cols][midpoint % cols];

            if (target == midElement) {
                return true;
            } else if (target < midElement) {
                right = midpoint - 1;
            } else if (target > midElement) {
                left = midpoint + 1;
            }
        }
        return false;
    }
}
