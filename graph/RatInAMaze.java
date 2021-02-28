package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class RatInAMaze {
    ArrayList<String> possiblePaths = new ArrayList<>();
    static int MAX_ELEMENTS_IN_ROW = 5;
    static String path = "";

    public static void main(String[] args) {
        RatInAMaze r = new RatInAMaze();
        int maze[][] = {{1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1}};
        r.printAllPossiblePaths(maze);
    }

    private void printAllPossiblePaths(int[][] maze) {
        int length = maze.length;

        boolean[][] visited = new boolean[length][MAX_ELEMENTS_IN_ROW];

        printPathUtil(0, 0, maze, length, visited);

        for (String possiblePath : possiblePaths) {
            System.out.print(possiblePath + " ");
        }
    }

    private void printPathUtil(int row, int col, int[][] maze, int size, boolean[][] visited) {
        if (row == -1 || row == size || col == -1 || col == size || visited[row][col] || maze[row][col] == 0) return;

        if (reachedDestination(row, col, size)) {
            possiblePaths.add(path);
            return;
        }

        visited[row][col] = true;

        if (isSafe(row + 1, col, maze, size, visited)) {
            path += 'D';
            printPathUtil(row + 1, col, maze, size, visited);
            path = path.substring(0, path.length() - 1);
        }

        if (isSafe(row, col - 1, maze, size, visited)) {
            path += 'L';
            printPathUtil(row, col - 1, maze, size, visited);
            path = path.substring(0, path.length() - 1);
        }

        if (isSafe(row, col + 1, maze, size, visited)) {
            path += 'R';
            printPathUtil(row, col + 1, maze, size, visited);
            path = path.substring(0, path.length() - 1);
        }

        if (isSafe(row - 1, col, maze, size, visited)) {
            path += 'U';
            printPathUtil(row - 1, col, maze, size, visited);
            path = path.substring(0, path.length() - 1);
        }

        visited[row][col] = false;
    }

    private boolean reachedDestination(int row, int col, int size) {
        return row == size - 1 && col == size - 1;
    }

    private boolean isSafe(int row, int col, int[][] maze, int size, boolean[][] visited) {
        if (row == -1 || row == size ||
                col == -1 || col == size ||
                visited[row][col] ||
                maze[row][col] == 0) {
            return false;
        }
        return true;
    }


}

