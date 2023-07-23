package array_examples;

//Sliding window ~~~~~~
public class NoOfSubarraysWhoseProductLessThanK {
    public static void main(String[] args) {
        NoOfSubarraysWhoseProductLessThanK s = new NoOfSubarraysWhoseProductLessThanK();
        System.out.println(s.longestSubArrayWhoseProductLessThanK(new int[]{10, 2, 3, 5, 2, 6}, 100));
        System.out.println(s.noOfSubArraysWhoseProductLessThanK(new int[]{10, 2, 3, 5, 2, 6}, 100));
    }

    public int longestSubArrayWhoseProductLessThanK(int[] arr, int k) {
        int left = 0, curr = 1, ans = 0, right = 0;

        for (; right < arr.length; right++) {
            curr *= arr[right];

            while (curr > k) {
                curr /= arr[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int noOfSubArraysWhoseProductLessThanK(int[] arr, int k) {
        int left = 0, curr = 1, ans = 0, right = 0;

        for (; right < arr.length; right++) {
            curr *= arr[right];

            while (curr > k) {
                curr /= arr[left];
                left++;
            }

            ans += right - left + 1;
        }
        return ans;
    }
}
