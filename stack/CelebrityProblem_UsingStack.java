package stack;

import java.util.Stack;

public class CelebrityProblem_UsingStack {
    int[][] acquaintance;

    public static void main(String[] args) {
        CelebrityProblem_UsingStack c = new CelebrityProblem_UsingStack();
        int m[][] = new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0},
        };
        System.out.println(c.findCelebrity(m, 3));

        int m2[][] = new int[][]{
                {0, 1},
                {1, 0},
        };

        System.out.println(c.findCelebrity(m2, 2));
    }

    private int findCelebrity(int m[][], int n) {
        acquaintance = m;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (knows(a, b)) {
                stack.push(b);
            } else stack.push(a);

        }

        if (stack.isEmpty()) return -1;
        Integer potentialCeleb = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != potentialCeleb && !knows(i, potentialCeleb) || knows(potentialCeleb, i)) return -1;
        }
        return potentialCeleb;
    }

    private boolean knows(int a, int b) {
        return acquaintance[a][b] == 1;
    }


}
