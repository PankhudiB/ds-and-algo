package array_examples;

import util.ArrayUtil;

class RemoveDuplicatesInPlace {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int lastUnique = 0;
        for (int curr=1; curr < nums.length; curr++){
            if (nums[curr] != nums[lastUnique] ){
                nums[lastUnique+1] = nums[curr];
                lastUnique++;
            }
        }
        ArrayUtil.print(nums);
        return lastUnique+1;
    }
}

