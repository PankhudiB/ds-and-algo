package recursion;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs p = new ClimbingStairs();
        int waysToClimb5 = p.waysToClimb(4);
        System.out.println(waysToClimb5);
        int waysToClimb6 = p.waysToClimb(6);
        System.out.println(waysToClimb6);
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
        int i1 = climb_Stairs(i + 1, n);
        int i2 = climb_Stairs(i + 2, n);
        return i1 + i2;
    }
}

//1 - 1
//2 - 11, 2
//3 - 111,12,21
//4 - 1111,22,112,121,211
//5 - 11111,122,212,221,2111,1211,1121,1112,
