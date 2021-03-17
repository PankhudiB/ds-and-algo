package graph;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands r = new NumberOfIslands();
        char map[][] = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println("noOfIslands :" + r.noOfIslands(map));

        char map2[][] = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("noOfIslands :" + r.noOfIslands(map2));
    }

    private int noOfIslands(char[][] map) {
        if (map == null || map.length == 0) return 0;

        int noOfIslands = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '1') {
                    noOfIslands += dfs(map, i, j);
                }
            }
        }
        return noOfIslands;
    }

    private int dfs(char[][] map, int i, int j) {
        if (notSafe(map, i, j) || map[i][j] == '0') {
            return 0;
        }
        map[i][j] = '0';        // so that you dont account for it again
        dfs(map, i + 1, j);
        dfs(map, i - 1, j);
        dfs(map, i, j + 1);
        dfs(map, i, j - 1);
        return 1;
    }

    private boolean notSafe(char[][] map, int i, int j) {
        return (i < 0 || i >= map.length || j < 0 || j >= map[i].length);
    }
}