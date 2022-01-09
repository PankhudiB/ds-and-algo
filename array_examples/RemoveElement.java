package array_examples;

class RemoveElement {
    public static void main(String[] args) {
        System.out.println("expected : 2 | got : " + removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println("expected : 5 | got : " + removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println("expected : 0 | got : " + removeElement(new int[]{}, 0));
        System.out.println("expected : 1 | got : " + removeElement(new int[]{2}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int val_first_at = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && val_first_at == -1) {
                val_first_at = i;
            } else if (nums[i] != val && val_first_at != -1) {
                nums[val_first_at] = nums[i];
                nums[i] = val;
                val_first_at = val_first_at + 1;
            }
        }
        return (val_first_at == -1) ? nums.length : val_first_at;
    }
}