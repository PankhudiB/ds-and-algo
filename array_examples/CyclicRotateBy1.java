package array_examples;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

class CyclicRotateBy1 {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        ArrayUtil.print(original);
        int[] shiftedRight = cyclicRotateBy1(original);
        ArrayUtil.print(shiftedRight);
        ArrayUtil.print(antiCyclicRotateBy1(shiftedRight));
        int[] ori2 = {9, 8, 7, 6, 4, 2, 1, 3};
        ArrayUtil.print(ori2);
        int[] arr2 = cyclicRotateBy1(ori2);
        ArrayUtil.print(arr2);
        ArrayUtil.print(antiCyclicRotateBy1(arr2));
    }

    public static int[] cyclicRotateBy1(int[] arr) {
        int n = arr.length - 1;
        int temp = arr[n];
        for (int i = n; i > 0; i--) {
            int desired_index = (n + (i - 1)) % n;
            arr[i] = arr[desired_index];
        }
        arr[0] = temp;
        return arr;
    }

    public static int[] antiCyclicRotateBy1(int[] arr) {
        int total = arr.length;
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            int desired_index = (total + (i + 1)) % total;
            arr[i] = arr[desired_index];
        }
        arr[total - 1] = temp;
        return arr;
    }
}

