package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    Pseudo-code

dfs-recursive(curr, pathSoFar)
   with base condition -> target found
   else
        loop over neighbors
            if neighbor not already in curr path
                pathSoFar.add(neigh)
                dfs-recursive(neigh. pathSoFar)
                pathSoFar.remove(neigh)

TC ->
no of possible paths => between 2 nodes --> 2^N - 1 no of paths
To construct each path -- we will need O(N)

TC => O(N * 2^N)

*/
public class AllPathsFromSourceToTarget_ {
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
        AllPathsFromSourceToTarget_ r = new AllPathsFromSourceToTarget_();
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