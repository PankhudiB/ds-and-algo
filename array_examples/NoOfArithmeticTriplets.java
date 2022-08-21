package array_examples;

import java.util.HashSet;

public class NoOfArithmeticTriplets {
    public static void main(String[] args) {
        System.out.println(noOfArithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
    }

    public static int noOfArithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int num: nums) {
            if(set.contains(num - diff) && set.contains(num - 2*diff)){
                count++;
            }
            set.add(num);
        }
        return count;
    }
}
