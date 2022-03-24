package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourcetoTargetSolvingAgain {
    public static void main(String[] args) {
        int[][] graph1 = new int[][]{{1, 2}, {3}, {3}, {}};
        int[][] graph2 = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
    }

    List<List<Integer>> result;
    int target;
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.result = new ArrayList();
        int n = graph.length;
        this.target = n - 1;
        this.graph = graph;
        LinkedList<Integer> pathSoFar = new LinkedList<Integer>();
        pathSoFar.add(0);
        dfs(pathSoFar, 0);

        return result;
    }

    private void dfs(LinkedList<Integer> pathSoFar, int curr) {
        if (curr == this.target) {
            this.result.add(new ArrayList<Integer>(pathSoFar));
            return;
        }
        for (int neigh : graph[curr]) {
            if (pathSoFar.contains(neigh)) continue;

            pathSoFar.addLast(neigh);
            dfs(pathSoFar, neigh);
            pathSoFar.removeLast();
        }
    }
}
