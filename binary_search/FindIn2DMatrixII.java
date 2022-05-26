package binary_search;

public class FindIn2DMatrixII {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 4}, {2, 5}}, 2));
        System.out.println(searchMatrix(new int[][]{{1, 4}, {2, 5}}, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowPtr = 0;
        int colPtr = cols - 1;

        while (rowPtr < rows && colPtr >= 0) {
            int pivot = matrix[rowPtr][colPtr];
            if (target == pivot) return true;
            if (target < pivot) {
                colPtr--;
            } else {
                rowPtr++;
            }
        }

        return false;
    }
}
