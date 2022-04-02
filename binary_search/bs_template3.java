package binary_search;

public class bs_template3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(bsTemplate3(nums, 1));
    }

    public static int bsTemplate3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 <= right) {
            System.out.print("L: " + left + "| R: " + right);
            int mid = left + (right - left) / 2;
            System.out.println("| M: " + mid);
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        //left+1== right
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

}

