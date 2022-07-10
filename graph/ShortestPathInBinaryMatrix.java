package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    int gridWidth = 0;
    int gridHeigth = 0;
    int[][] directions = new int[][]{{-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        gridWidth = grid.length;
        gridHeigth = grid[0].length;
        int targetX = grid.length - 1;
        int targetY = grid[0].length - 1;

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

            for (int[] neighbor : getNeighbors(x, y, grid)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];

                if (grid[nextX][nextY] == 0 || grid[nextX][nextY] > (currDist + 1)) {
                    grid[nextX][nextY] = currDist + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }

    private List<int[]> getNeighbors(int x, int y, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int d = 0; d < directions.length; d++) {
            int nextX = x + directions[d][0];
            int nextY = y + directions[d][1];
            if (outOfBound(nextX, nextY, grid)) continue;

            neighbours.add(new int[]{nextX, nextY});
        }
        return neighbours;
    }

    private boolean outOfBound(int x, int y, int[][] grid) {

        if (x >= gridWidth || x < 0 || y >= gridHeigth || y < 0 || grid[x][y] == 1) return true;
        else return false;
    }

}

