package binary_search;

public class bs_template2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(bsTemplate2(nums, 1));
    }

    public static int bsTemplate2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            System.out.print("L: " + left + "| R: " + right);
            int mid = left + (right - left) / 2;
            System.out.println("| M: " + mid);
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //left == right
        return (left != nums.length && nums[left] == target) ? left : -1;
    }

}

