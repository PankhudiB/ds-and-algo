package binary_search;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        int[] searchRange = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println("[" + searchRange[0] + "," + searchRange[1] + "]");

        int[] searchRange2 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println("[" + searchRange2[0] + "," + searchRange2[1] + "]");
    }

    public static int[] searchRange(int[] nums, int target) {
        int begin = findBound(nums, target, true);
        if (begin == -1) {
            return new int[]{-1, -1};
        }

        int end = findBound(nums, target, false);
        return new int[]{begin, end};
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int begin = 0, end = N - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == begin || nums[mid - 1] != target) return mid;
                    end = mid - 1;
                } else {
                    if (mid == end || nums[mid + 1] != target) return mid;
                    begin = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }
}
