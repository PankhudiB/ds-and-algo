package binary_search;

public class FindMinInRotatedArray {
    public static void main(String[] args) {
        System.out.println("min: " + findMinElement(new int[]{3, 4, 5, 1, 2}));
        System.out.println("min: " + findMinElement(new int[]{2, 4, 5, 6, 7, 0, 1}));
        System.out.println("min: " + findMinElement(new int[]{11, 13, 15, 17}));
        System.out.println("min: " + findMinElement(new int[]{5, 1, 2, 3, 4}));
    }

    public static int findMinElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int itr = 0;
        if (nums[right] > nums[0]) {
            return nums[0];
        }
        while (left <= right) {
            itr++;
            int mid = left + (right - left) / 2;
            System.out.println("L: " + nums[left] + " | R: " + nums[right] + " | M: " + mid + " | val:" + nums[mid]);
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
