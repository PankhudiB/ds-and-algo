package array_examples;

import java.util.*;
import java.lang.*;
import java.io.*;

//time complexity - O(n)
//space complexity - O(n)
class LonelyNumberUsingSet {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] input = new int[size];


        for (int i = 0; i < size; i++) {
            input[i] = sc.nextInt();
        }
        LonelyNumberUsingSet l = new LonelyNumberUsingSet();
        System.out.println(l.findLonelyNumber(input));
    }

    private int findLonelyNumber(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        int sumOfUniqueElements = 0;
        int sumOfAllElements = 0;

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            sumOfAllElements += arr[i];
        }

        for (int element : set) {
            sumOfUniqueElements += element;
        }

        // 2 * (a + b + c) - (a + a + b + b + c) == c
        return 2 * sumOfUniqueElements - sumOfAllElements;
    }
}

