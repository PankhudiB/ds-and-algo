package queue;

import util.Tuple;

import java.util.*;

class NumberOfIslands {
    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println(numIslands(grid1));

        int[][] grid2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}

        };
        System.out.println(numIslands(grid2));

    }

    private static boolean containsKeyForCustomKey(int[][] grid2) {
        Map<Tuple<Integer, Integer>, Boolean> visited = new HashMap<>();
        visited.put(new Tuple<>(1, 2), true);
        Set<Tuple<Integer, Integer>> keySet = visited.keySet();
        System.out.println(keySet.contains(new Tuple<>(1, 2)));
        return true;
    }

    public static int numIslands(int[][] grid) {
        Map<Tuple<Integer, Integer>, Boolean> visited = new HashMap<>();
        List<Tuple<Integer, Integer>> DIRECTIONS = Arrays.asList(
                new Tuple(0, 1),
                new Tuple(0, -1),
                new Tuple(1, 0),
                new Tuple(-1, 0)
        );
        int totalRows = grid.length;
        int totalCols = grid[0].length;

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                if (grid[i][j] == 1) {
                    visited.put(new Tuple<>(i, j), false);
                }
            }
        }

        int islands = 0;
        for (Map.Entry<Tuple<Integer, Integer>, Boolean> entry : visited.entrySet()) {
            if (visited.get(entry.getKey())) continue;
            islands++;
            Queue<Tuple<Integer, Integer>> q = new LinkedList<>();
            q.add(entry.getKey());
            visited.put(entry.getKey(), true);

            while (!q.isEmpty()) {
                Tuple<Integer, Integer> curr = q.poll();
                int cr = curr.first;
                int cc = curr.second;
                for (Tuple<Integer, Integer> direction : DIRECTIONS) {
                    int nr = cr + direction.first;
                    int nc = cc + direction.second;

                    if (nr < 0 || nc < 0 || nr >= totalRows || nc >= totalCols) {
                        continue;
                    }

                    if (visited.containsKey(new Tuple<>(nr, nc)) && !visited.get(new Tuple<>(nr, nc))) {
                        q.add(new Tuple<>(nr, nc));
                        visited.put(new Tuple<>(nr, nc), true);
                    }
                }
            }
        }
        return islands;
    }
}