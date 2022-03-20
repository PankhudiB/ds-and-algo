package graph;

import java.util.*;

public class FindifPathExistsinGraph {
    public static void main(String[] args) {
        int[][] edges1 = new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        System.out.println(validPath(6, edges1, 0, 5));

        int[][] edges2 = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        System.out.println(validPath(3, edges2, 0, 2));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(source);

        Set<Integer> seen = new HashSet<>();

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (curr == destination) return true;
            if (seen.contains(curr)) continue;
            seen.add(curr);

            for (int neigh : adj.get(curr)) {
                stack.push(neigh);
            }
        }
        return false;
    }
}
