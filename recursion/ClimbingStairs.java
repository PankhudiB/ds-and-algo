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
}

//1 - 1
//2 - 11, 2
//3 - 111,12,21
//4 - 1111,22,112,121,211
//5 - 11111,122,212,221,2111,1211,1121,1112,
