package queue;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslandsUsingBFS_cheap_trick_of_storing_row_col {
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


    public static int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int noOfIslands = 0;
        if (grid == null || grid.length == 0) return 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++noOfIslands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbours = new LinkedList<>();
                    neighbours.add(r * nc + c);

                    while (!neighbours.isEmpty()) {
                        int id = neighbours.poll();
                        int row = id / nc;
                        int col = id % nc;

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbours.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbours.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }

                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbours.add((row) * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbours.add((row) * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return noOfIslands;
    }
}