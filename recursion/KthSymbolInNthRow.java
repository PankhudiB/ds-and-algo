package recursion;

import java.util.ArrayList;
import java.util.List;

/*
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
 */
public class KthSymbolInNthRow {
    public static void main(String[] args) {
        KthSymbolInNthRow k = new KthSymbolInNthRow();

        System.out.println(k.kthSymbolInNthRow(2, 1));
    }

    public int kthSymbolInNthRow(int n, int k) {
        List<String> result = new ArrayList<>();
        result.add("0");

        for (int i = 1; i < n; i++) {
            String prev = result.get(i - 1);
            prev = prev.replace("0", "2");
            prev = prev.replace("1", "10");
            prev = prev.replace("2", "01");
            result.add(prev);
        }
        return Integer.parseInt("" + result.get(n - 1).charAt(k-1));
    }
}
