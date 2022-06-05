package backtracking;

import java.util.HashSet;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char val = board[i][j];
                if (val == '.') {
                    continue;
                }

                if (rows[i].contains(val) || cols[j].contains(val)) return false;
                int box = (i / 3) * 3 + (j / 3);
                if (boxes[box].contains(val)) return false;

                rows[i].add(val);
                cols[j].add(val);
                boxes[box].add(val);
            }
        }
        return true;
    }

}
