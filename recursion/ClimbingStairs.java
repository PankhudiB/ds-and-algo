package recursion;

import java.util.HashMap;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs p = new ClimbingStairs();
        int waysToClimb5 = p.waysToClimb(4);
        System.out.println(waysToClimb5);
        int waysToClimb6 = p.waysToClimb(6);
        System.out.println(waysToClimb6);

        int waysToClimbWithMemo5 = p.waysToClimbWithMemo(5);
        System.out.println(waysToClimbWithMemo5);
        int waysToClimbWithMemo6 = p.waysToClimbWithMemo(6);
        System.out.println(waysToClimbWithMemo6);

        int climb_stairs_like_fibo5 = p.climb_stairs_like_fibo(5);
        System.out.println(climb_stairs_like_fibo5);
        int climb_stairs_like_fibo6 = p.climb_stairs_like_fibo(6);
        System.out.println(climb_stairs_like_fibo6);
    }

    private int waysToClimb(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    private int waysToClimbWithMemo(int n) {
        cache = new HashMap<>();
        return climb_Stairs_memo(0, n);
    }

    HashMap<Integer, Integer> cache = new HashMap<>();

    public int climb_Stairs_memo(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (cache.containsKey(i)) return cache.get(i);
        int i1 = climb_Stairs_memo(i + 1, n);
        int i2 = climb_Stairs_memo(i + 2, n);
        cache.put(i, (i1 + i2));
        return i1 + i2;
    }

    public int climb_stairs_like_fibo(int n) {
        if (n <= 2) return n;

        int prev1 = 1;
        int prev2 = 2;
        int curr = 0;

        for (int i = 3; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return curr;
    }
}

//1 - 1
//2 - 11, 2
//3 - 111,12,21
//4 - 1111,22,112,121,211
//5 - 11111,122,212,221,2111,1211,1121,1112,
