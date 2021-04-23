package stack;

public class CelebrityProblem_Recursion {
    int[][] acquaintance;

    public static void main(String[] args) {
        CelebrityProblem_Recursion c = new CelebrityProblem_Recursion();
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
        int potentialCelebIndex = potentialCeleb(n);
        if (potentialCelebIndex == -1)
            return potentialCelebIndex;
        else {
            int every1KnowsCeleb = 0;
            int celebKnowsSome1 = 0;
            for (int i = 0; i < n; i++) {
                if (i != potentialCelebIndex) {
                    every1KnowsCeleb += knows(i, potentialCelebIndex);
                    celebKnowsSome1 += knows(potentialCelebIndex, i);
                }
            }
            if (every1KnowsCeleb == n - 1 && celebKnowsSome1 == 0) {
                return potentialCelebIndex;
            }
        }
        return -1;
    }

    private int potentialCeleb(int noOfPeople) {
        if (noOfPeople == 0) return -1;
        int indexOfPotentialCeleb = potentialCeleb(noOfPeople - 1);

        // this will be true for when curr call is made for n = 1,
        //and otherwise non of the 2 folks from previous recursive call were potential celeb
        if (indexOfPotentialCeleb == -1) return 0;

        if (knows(indexOfPotentialCeleb, noOfPeople - 1) == 1) {
            return noOfPeople - 1;
        } else if (knows(noOfPeople - 1, indexOfPotentialCeleb) == 1)
            return indexOfPotentialCeleb;

        return -1; // the pair selected doesnt know each other.
    }

    private int knows(int a, int b) {
        return acquaintance[a][b];
    }


}
