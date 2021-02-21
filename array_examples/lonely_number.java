package array_examples;

import java.util.*;
import java.lang.*;

//time complexity - O(n)
//space complexity - O(1)
class LonelyNumberWithBitManipulation {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] input = new int[size];
        int xor_output = 0;

        for (int i = 0; i < size; i++) {
            input[i] = sc.nextInt();
            xor_output = xor_output ^ input[i];
        }

        System.out.println(xor_output);
    }
}

