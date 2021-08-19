package array_examples;

import java.util.Arrays;

class SortedSquares {
    public static void main(String[] args) throws Exception {
        int[] input = new int[]{-4, -1, 0, 3, 10};
//        expected -> [0,1,9,16,100]
        Arrays.stream(sortedSquares(input)).forEach(num -> System.out.print(num + " "));
        System.out.println();
        Arrays.stream(sortedSquaresEfficient(input)).forEach(num -> System.out.print(num + " "));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squares[i] = nums[i] * nums[i];
        }
        Arrays.sort(squares);
        return squares;
    }

    public static int[] sortedSquaresEfficient(int[] nums) {
        int[] result = new int[nums.length];
        int resultIndex = nums.length - 1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] * nums[start] > nums[end] * nums[end]) {
                result[resultIndex--] = nums[start] * nums[start];
                start++;
            } else {
                result[resultIndex--] = nums[end] * nums[end];
                end--;
            }
        }

        return result;
    }

}

