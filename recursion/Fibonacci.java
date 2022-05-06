package recursion;


import java.util.HashMap;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci p = new Fibonacci();
        Integer fibo5 = p.fibo(5);
        System.out.println(fibo5);
        Integer fibo6 = p.fibo(6);
        System.out.println(fibo6);

        Integer fiboWithMemo5 = p.fiboWithMemo(5);
        System.out.println(fiboWithMemo5);
        Integer fiboWithMemo6 = p.fiboWithMemo(6);
        System.out.println(fiboWithMemo6);

        Integer fiboIterative5 = p.fiboIterativeRememberOnlyLast2InsteadOfCache(5);
        System.out.println(fiboIterative5);
        Integer fiboIterative6 = p.fiboIterativeRememberOnlyLast2InsteadOfCache(6);
        System.out.println(fiboIterative6);

    }

    public int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    HashMap<Integer, Integer> cache = new HashMap<>();

    public Integer fiboWithMemo(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        int result;
        if (n < 2) {
            result = n;
        } else {
            result = fiboWithMemo(n - 1) + fiboWithMemo(n - 2);
        }
        cache.put(n, result);
        return result;
    }

    public Integer fiboIterativeRememberOnlyLast2InsteadOfCache(int n) {
        if (n < 2) return n;

        int prev1 = 1;
        int prev2 = 0;
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}
