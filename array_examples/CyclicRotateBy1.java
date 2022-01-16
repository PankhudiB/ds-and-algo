package array_examples;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

class CyclicRotateBy1 {
    public static void main(String[] args) {
        ArrayUtil.print(cyclicRotateBy1(new int[]{1, 2, 3, 4, 5}));
        ArrayUtil.print(cyclicRotateBy1(new int[]{9, 8, 7, 6, 4, 2, 1, 3}));
        ArrayUtil.print(cyclicRotateBy1(new int[]{1}));
    }

    public static int[] cyclicRotateBy1(int[] arr) {
        int n = arr.length -1;
        int temp = arr[n];
        for (int i = n; i > 0; i--) {
            int desired_index = (n + (i - 1)) % n;
            arr[i] = arr[desired_index];
        }
        arr[0] = temp;
        return arr;
    }
}

