package util;

//Combination
public class NCR {
    public static void main(String[] args) {
        System.out.println(nCr(2, 2));
        System.out.println(nCr(4, 2));
    }
    
    public static int nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
