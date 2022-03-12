package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class WallsAndGates {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int WALL = -1;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0}
    );

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int totalRows = rooms.length;
        int totalCols = rooms[0].length;

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == GATE) {
                    queue.offer(new int[]{i, j});
                }
            }
        }


        while (!queue.isEmpty()) {
            int[] currRoom = queue.poll();
            int r = currRoom[0];
            int c = currRoom[1];
            for (int[] direction : DIRECTIONS) {
                int row = r + direction[0];
                int col = c + direction[1];
                if (row < 0 || row >= totalRows || col < 0 || col >= totalCols || rooms[row][col] != EMPTY) {
                    continue;
                }
                rooms[row][col] = rooms[r][c] + 1;
                queue.add(new int[]{row, col});
            }

        }
    }
}