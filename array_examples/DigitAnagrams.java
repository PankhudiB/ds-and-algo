package array_examples;

import java.util.HashMap;
import java.util.Map;

public class DigitAnagrams {
    public static void main(String[] args) {
        DigitAnagrams d = new DigitAnagrams();
        System.out.println(d.noOfDigitAnagramPairs(new int[]{25, 35, 228, 53, 278, 872, 782}));
    }

    public int noOfDigitAnagramPairs(int[] arr) {
        Map<Map<Integer, Integer>, Integer> digitAnagrams = new HashMap<>();

        for (int no : arr) {
            Map<Integer, Integer> elementDigitOccurrence = new HashMap<>();
            while (no > 0) {
                int digit = no % 10;
                no = no / 10;
                elementDigitOccurrence.put(digit, elementDigitOccurrence.getOrDefault(digit, 0) + 1);
            }

            digitAnagrams.put(elementDigitOccurrence, digitAnagrams.getOrDefault(elementDigitOccurrence, 0) + 1);
        }

        int sum = 0;
        for (int val : digitAnagrams.values()) {
            sum += nCr(val, 2);
        }
        return sum;
    }

    static int nCr(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n) {
        if (n == 0)
            return 1;
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}
