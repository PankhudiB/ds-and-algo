package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    List<List<String>> solutions = new ArrayList<List<String>>();
    int size;

    public List<List<String>> solveNQueens(int n) {
        size = n;
        char emptyBoard[][] = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                emptyBoard[i][j] = '.';
            }
        }

        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }

    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();

        for (int row = 0; row < size; row++) {
            String currRow = new String(state[row]);
            board.add(currRow);
        }
        return board;
    }

    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, char[][] state) {
        if (row == size) {
            //stop when u reach beyond last row
            solutions.add(createBoard(state));
            return;
        }

        for (int col = 0; col < size; col++) {

            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;

            //check if under attack
            if (diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal) || cols.contains(col)) {
                continue;
            }

            //Place queen
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            cols.add(col);
            state[row][col] = 'Q';

            //advance to figure out for next row
            backtrack(row + 1, diagonals, antiDiagonals, cols, state);

            //Remove Queen
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            cols.remove(col);
            state[row][col] = '.';
        }
    }
}
