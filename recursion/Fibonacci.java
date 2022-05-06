package recursion;


public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci p = new Fibonacci();
        Integer fibo5 = p.fibo(5);
        System.out.println(fibo5);
        Integer fibo6 = p.fibo(6);
        System.out.println(fibo6);
    }

    public int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
