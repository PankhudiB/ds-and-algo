package array_examples;

import java.util.Scanner;

class IsMountain {
    public static void main(String[] args) throws Exception {
        int arr[] = new int[]{0,1,2,4,3,1};
        System.out.println(validMountainArray(arr));
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        boolean increasing = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == 0) {
                return false;
            }
            if (increasing == true) {
                if (arr[i + 1] - arr[i] > 0) {
                } else if (arr[i + 1] - arr[i] < 0) {
                    if (i == 0) return false;
                    increasing = false;
                }
            } else {
                if (arr[i + 1] - arr[i] > 0) {
                    return false;
                }
            }
        }
        if (increasing == true) return false;
        else return true;
    }
}

