package stack;

import java.util.Stack;

public class CelebrityProblem_TwoPointer {
    int[][] acquaintance;

    public static void main(String[] args) {
        CelebrityProblem_TwoPointer c = new CelebrityProblem_TwoPointer();
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
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (knows(i, j)) i++;
            else j--;
        }

        int potentialCeleb = i;
        for (int ppl = 0; ppl < n; ppl++) {
            if (ppl != potentialCeleb && !knows(ppl, potentialCeleb) || knows(potentialCeleb, ppl)) return -1;
        }
        return potentialCeleb;
    }

    private boolean knows(int a, int b) {
        return acquaintance[a][b] == 1;
    }
}
