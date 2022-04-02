package binary_search;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    // find mid --> compare with mid+1
    //              --> if mid lies on descending sequence || local falling slope -> \ -> peak will be on left
    //              --> if mid lies on ascending sequence || local rising slope -> / -> peak will be on right
     
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
