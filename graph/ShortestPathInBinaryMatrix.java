package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid1));

        int[][] grid2 = {{0, 1}, {1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid2));


    }

    static int gridWidth = 0;
    static int gridHeigth = 0;

    public static int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        gridWidth = grid.length;
        gridHeigth = grid[0].length;
        int targetX = grid.length - 1;
        int targetY = grid[0].length - 1;

        int[][] directions = new int[][]{{-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}};
        if (grid[0][0] == 1 || grid[targetX][targetY] == 1) return -1;

        grid[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int x = curr[0];
            int y = curr[1];
            int currDist = grid[x][y];

            if (x == targetX && y == targetY) {
                return currDist;
            }

            for (int d = 0; d < directions.length; d++) {
                int nextX = x + directions[d][0];
                int nextY = y + directions[d][1];
                if (outOfBound(nextX, nextY, grid)) continue;
                if (grid[nextX][nextY] == 0 || grid[nextX][nextY] > (currDist + 1)) {
                    grid[nextX][nextY] = currDist + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }

    private static boolean outOfBound(int x, int y, int[][] grid) {
        if (x >= gridWidth || x < 0 || y >= gridHeigth || y < 0 || grid[x][y] == 1) return true;
        else return false;
    }
}

