package graph.algos;

public class SurroundedRegions {
    int rows;
    int cols;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // start from 0s that are on boarder -> dfs
    public void solve(char[][] board) {

        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == rows - 1 || j == cols - 1)) {
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(int i, int j, char[][] board) {
        board[i][j] = 'N';
        for (int[] direction : directions) {
            int next_i = i + direction[0];
            int next_j = j + direction[1];

            if (isSafe(next_i, next_j) && board[next_i][next_j] == 'O') {
                dfs(next_i, next_j, board);
            }
        }
    }

    private boolean isSafe(int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) return true;
        return false;
    }
}