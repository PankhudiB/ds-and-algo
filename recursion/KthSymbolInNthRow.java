package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
 */
public class KthSymbolInNthRow {
    public static void main(String[] args) {
        KthSymbolInNthRow k = new KthSymbolInNthRow();

        System.out.println(k.kthGrammerBruteForce(7, 1));
        
        System.out.println(k.getKthGrammar(1, 1));
    }

    public int kthGrammerBruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        result.add("0");
        HashMap<String, String> cache = new HashMap<>();

        for (int i = 1; i < n; i++) {
            String prevCopy = result.get(i - 1);
            String prev = result.get(i - 1);
            prev = prev.replace("0", "2");
            prev = prev.replace("1", "10");
            prev = prev.replace("2", "01");
            result.add(prev);
            System.out.println("i: " + (i + 1) + " | before: " + prevCopy + " | after: " + result.get(i));
        }
        return Integer.parseInt("" + result.get(n - 1).charAt(k - 1));
    }

    // nth -> prevNth + inverted(prevNth)
    /*
          n -> size             val             kth
        n 1 -> 1                0
        n 2 -> 2                01
        n 3 -> 4                0110
        n 4 -> 8 -> 2^(n-1)     01101001
        n 5 -> 16               0110100110010110

        observagtion :
        at every stage ->  it is --> prev stage + Negation(prev stage)
        so keep finding if K lies in 1st half or 2nd half

        mid => will depend on length -> length = 2 ^(n-1)

        -> if it lies in 1 st half of reference ---> recursive call for previous row -> kthGrammer(N-1,k)
        -> if it lies in 2nd half -> then call kthGrammer(N-1,k-mid) and flip the result
     */
    
    
    public int getKthGrammar(int n, int k) {
        if (n == 1 && k == 1) return 0;
        int mid = (int) Math.pow(2, (n - 1)) / 2;
        if (k <= mid) {
            return getKthGrammar(n - 1, k);
        }
        int result = getKthGrammar(n - 1, k - mid);
        return result == 0 ? 1 : 0;
    }

}
