package stack;

public class CelebrityProblem {

    public static void main(String[] args) {
        int m[][] = new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0},
        };
        System.out.println(findCelebrity(m));

        int m2[][] = new int[][]{
                {0, 1},
                {1, 0},
        };

        System.out.println(findCelebrity(m2));
    }

    private static int findCelebrity(int m[][]) {
        int celebrity = -1;
        for (int row = 0; row < m.length; row++) {
            boolean every1KnowsCeleb = true;
            for (int col = 0; col < m[row].length; col++) {
                if (col != row && m[col][row] != 1) {
                    every1KnowsCeleb = false;
                }
            }
            if (every1KnowsCeleb) {
                boolean doesCelebKnowAny1 = false;
                int[] celebAcquataince = m[row];
                for (int i = 0; i < celebAcquataince.length; i++) {
                    if (celebAcquataince[i] == 1)
                        doesCelebKnowAny1 = true;
                }
                if (!doesCelebKnowAny1)
                    celebrity = row;
            }
        }
        return celebrity;
    }
}
