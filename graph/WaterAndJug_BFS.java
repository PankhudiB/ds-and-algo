package graph;

import java.util.*;

class WaterAndJug_BFS {
    public static void main(String[] args) {
        WaterAndJug_BFS c = new WaterAndJug_BFS();
        System.out.println(c.canMeasureWater(4, 3, 2));
        System.out.println(c.canMeasureWater(5, 3, 4));
    }

    private boolean canMeasureWater(int jug1, int jug2, int target) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        int[] options = new int[]{jug1, jug2, -jug1, -jug2};
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            visited.add(curr);
            for (int option : options) {
                int next = curr + option;
                if (next == target) {
                    return true;
                }
                if (next > 0 && next < jug1 + jug2 && !visited.contains(next)) {
                    queue.add(next);
                }
            }
        }
        return false;
    }
}