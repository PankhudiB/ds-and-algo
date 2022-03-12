package queue;

import util.Tuple;

import java.util.*;

class NumberOfIslandsUsingDFS {
    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid1));

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}

        };
        System.out.println(numIslands(grid2));

    }

    private static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') return;

        grid[r][c] = '0';
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
    }

    public static int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int noOfIslands = 0;
        if (grid == null || grid.length == 0) return 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    noOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return noOfIslands;
    }
}