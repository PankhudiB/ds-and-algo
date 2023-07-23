package array_examples;

//Sliding window ~~~~~~
public class LargestSubarrayWithSumLessThanK {
    public static void main(String[] args) {
        LargestSubarrayWithSumLessThanK s = new LargestSubarrayWithSumLessThanK();
        System.out.println(s.largestSubarrayWithSumLessThanK(new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5}, 8));
    }

    private int largestSubarrayWithSumLessThanK(int[] arr, int k) {
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < arr.length; right++) {
            curr += arr[right];
            while (curr > k) {
                curr -= arr[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
