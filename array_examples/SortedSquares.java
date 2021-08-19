package array_examples;

import java.util.Arrays;

class SortedSquares {
    public static void main(String[] args) throws Exception {
        int[] input = new int[]{-4, -1, 0, 3, 10};
//        expected -> [0,1,9,16,100]
        int[] result = sortedSquares(input);
        Arrays.stream(result).forEach(num -> System.out.print(num + " "));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squares[i] = nums[i] * nums[i];
        }
        Arrays.sort(squares);
        return squares;
    }
}

