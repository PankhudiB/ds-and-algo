package util;

import java.util.List;

public class ArrayUtil {
    public static void print(int[] arr) {
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void print(List<Integer> arr) {
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
