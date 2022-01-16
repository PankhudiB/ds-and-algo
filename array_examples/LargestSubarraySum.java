package array_examples;

class LargestSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}, 8));
        System.out.println(maxSubarraySum(new int[]{-2, -3, -1, -4}, 4));
    }

    static long maxSubarraySum(int arr[], int n) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (int i = 0; i < n; i++) {
            maxEndingHere += arr[i];
            if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
            if (maxEndingHere < 0) maxEndingHere = 0;
        }
        return maxSoFar;
    }
}

