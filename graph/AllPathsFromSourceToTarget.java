package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    int target;
    List<List<Integer>> allPossiblePaths;
    int[][] graph;

    //                -------------|
    //             /               |
    //            /      0 ------> 1
    //           /    /     \   /     \
    //          /    /       \ /       \
    //         /     v        v         v
    //         ---> 4  <----- 3 <------- 2

    public static void main(String[] args) {
        AllPathsFromSourceToTarget r = new AllPathsFromSourceToTarget();
        int maze[][] = {{4, 3, 1}, {3, 2, 4}, {3}, {0, 4}, {}};
        System.out.println(r.allPathsSourceTarget(maze));

        int maze2[][] = {{1}, {}};
        System.out.println(r.allPathsSourceTarget(maze2));
    }

    private List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.target = graph.length - 1;
        this.graph = graph;
        this.allPossiblePaths = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        backtrack(0, path);
        return this.allPossiblePaths;
    }

    private void backtrack(int curr, LinkedList<Integer> pathSoFar) {
        if (curr == this.target) {
            this.allPossiblePaths.add(new ArrayList<>(pathSoFar));
            return;
        }

        for (Integer nextNode : graph[curr]) {
            if (!pathSoFar.contains(nextNode)) {
                pathSoFar.addLast(nextNode);
                backtrack(nextNode, pathSoFar);
                pathSoFar.removeLast();
            }
        }
    }

}