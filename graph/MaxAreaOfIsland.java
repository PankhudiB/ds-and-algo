package graph;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        MaxAreaOfIsland r = new MaxAreaOfIsland();
        int map[][] = {{1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println("maxAreaOfIsland :" + r.maxAreaOfIsland(map));

        int map2[][] = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println("maxAreaOfIsland :" + r.maxAreaOfIsland(map2));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int maxIslandSize = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int islandSize = dfs(grid, i, j);
                    maxIslandSize = Math.max(maxIslandSize, islandSize);
                }
            }
        }
        return maxIslandSize;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (notSafe(grid, r, c) || grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        int soFar = 0;
        soFar += dfs(grid, r + 1, c);
        soFar += dfs(grid, r - 1, c);
        soFar += dfs(grid, r, c + 1);
        soFar += dfs(grid, r, c - 1);

        return 1 + soFar;
    }

    private boolean notSafe(int[][] grid, int i, int j) {
        return (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length);
    }
}