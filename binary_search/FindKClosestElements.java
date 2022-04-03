package binary_search;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public static void main(String[] args) {
        findKClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        findKClosestElements(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 5, 4);
        findKClosestElements(new int[]{1}, 1, 1);
        findKClosestElements(new int[]{1, 5, 10}, 1, 4);
    }

    public static List<Integer> findKClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        if (arr.length <= k) {
            for (int i = 0; i < arr.length - 1; i++) {
                result.add(arr[i]);
            }
        }

        int closestElement = findClosestElement(arr, x);

        int left = closestElement - 1;
        int right = closestElement;

//        System.out.println(left + "," + right);

        while (right - left - 1 < k) {
            if (left == -1) {
                right += 1;
                continue;
            }
            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left -= 1;
            } else {
                right += 1;
            }
        }

//        System.out.println(left + "," + right);
        System.out.println(arr[left + 1] + "," + arr[right - 1]);

        return extractResultFromArray(arr, result, left, right);
    }

    private static List<Integer> extractResultFromArray(int[] arr, List<Integer> result, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    private static int findClosestElement(int[] arr, int x) {
        int left = 0, right = arr.length;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
