package basic_algo_template;

public class Check2CellsLieOnSameDiagonalOrAntidiagonal {
    public void check2CellsLieOnSameDiagonalOrAntidiagonal() {

        // Useful For problems where you have identify whether :
        //      elements are lying on same Diagonals || AntiDiagonals
        //      Eg. N-QUEENS PROBLEM

        int[][] matrix = new int[][]{
                {1, 2, 0, 6, 0},
                {2, 3, 3, 8, 5},
                {0, 3, 4, 0, 7},
                {6, 8, 0, 2, 9},
                {0, 5, 7, 9, 3}};

        // Diagonal ->  the difference between the row and column indexes (row - col) will be constant.
        // AntiDiagonal -> the sum of the row and column indexes (row + col) will be constant.

    }
}
