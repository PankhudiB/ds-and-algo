package array_examples;/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class LonelyNumber {
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

