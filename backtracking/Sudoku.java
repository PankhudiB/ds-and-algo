package backtracking;

public class Sudoku {
    int n = 3;
    int N = n * n;
    char[][] board = new char[N][N];
    int[][] rows = new int[N][N + 1];
    int[][] cols = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];
    boolean sudokuSolved = false;

    private boolean canPlace(int number, int row, int col) {
        int box = (row / n) * n + (col / n);
        return rows[row][number] + cols[col][number] + boxes[box][number] == 0;
    }

    private void putNumber(int number, int row, int col) {
        rows[row][number]++;
        cols[col][number]++;

        int box = (row / 3) * 3 + (col / 3);
        boxes[box][number]++;
        board[row][col] = (char) (number + '0');
    }

    private void removeNumber(int number, int row, int col) {
        rows[row][number]--;
        cols[col][number]--;

        int box = (row / 3) * 3 + (col / 3);
        boxes[box][number]--;
        board[row][col] = '.';
    }

    private void placeNextNumber(int row, int col) {
        if ((col == N - 1) && (row == N - 1)) sudokuSolved = true;
        else {
            if (col == N - 1) backtrack(row + 1, 0);
            else backtrack(row, col + 1);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int number = Character.getNumericValue(num);
                    putNumber(number, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    private void backtrack(int row, int col) {

        if (board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (canPlace(d, row, col)) {
                    putNumber(d, row, col);
                    placeNextNumber(row, col);

                    if (!sudokuSolved) removeNumber(d, row, col);
                }
            }
        } else placeNextNumber(row, col);
    }
}
