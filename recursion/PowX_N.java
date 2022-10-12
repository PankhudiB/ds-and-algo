package recursion;


import java.util.HashMap;

public class PowX_N {
    public static void main(String[] args) {
        PowX_N p = new PowX_N();

        double pow1 = p.pow(2, -2);
        System.out.println(pow1);
        double pow2 = p.pow(2, 2);
        System.out.println(pow2);

        double powRecursiveEfficient1 = p.powRecursiveEfficient(2, 10);
        System.out.println(powRecursiveEfficient1);
        double powRecursiveEfficient2 = p.powRecursiveEfficient(2, 2);
        System.out.println(powRecursiveEfficient2);

        double powIterativeEfficient1 = p.powIterativeEfficient(2, 10);
        System.out.println(powIterativeEfficient1);
        double powIterativeEfficient2 = p.powIterativeEfficient(2, 2);
        System.out.println(powIterativeEfficient2);

    }

    private double pow(int x, int n) {
        double double_x = 0.0;
        if (n < 0) {
            double_x = (double) 1 / x;
            n = -n;
        }
        double ans = 1.0;
        for (int i = 0; i < n; i++) {
            ans = ans * double_x;
        }
        return ans;
    }

    public double powRecursiveEfficient(int x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return helper(x, n);
    }

    private double helper(int x, int n) {
        if (n == 0) return 1.0;
        double half = helper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double powIterativeEfficient(int x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1.0;

        for (long i = N; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                ans = ans * x;
            }
            x = x * x;
        }
        return ans;
    }
}
