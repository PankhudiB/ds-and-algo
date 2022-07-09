package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class ValidArrangementsOfPair {
    public static void main(String[] args) {
        int[][] pairs = new int[][]{
                {5, 1}, {4, 5}, {11, 9}, {9, 4}
        };
        int[][] ans = validArrangement(pairs);

        for (int[] pair : ans) {
            System.out.print("[" + pair[0] + "," + pair[1] + "],");
        }

        System.out.println("------");
        int[][] pairs2 = new int[][]{
                {1, 2}, {1, 3}, {2, 1}
        };
        int[][] ans2 = validArrangement(pairs2);

        for (int[] pair : ans2) {
            System.out.print("[" + pair[0] + "," + pair[1] + "],");
        }
    }

    /*
        1. First create graph
        2. [IMP] maintain outdegrees - indegrees --> whichever node has this +ve -> can be the start node
        3. start dfs with this start node
            dfs(src)
            1. get neighbors of this src
            2. remove last neigh from Adj list of src
            3. start dfs for this node
            4. add to ans -> addAtFirst([src,next]);

        THIS IS EULERIAN-CIRCUIT ------> REVERSE DFS

        TC -> O(E) , E being edges
     */
    static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    static Stack<int[]> ans = new Stack<>();

    public static int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, Integer> outdegree = new HashMap<>();

        for (int i = 0; i < pairs.length; i++) {
            int src = pairs[i][0];
            int dest = pairs[i][1];

            graph.putIfAbsent(src, new ArrayList<>());
            graph.get(src).add(dest);
            outdegree.put(src, outdegree.getOrDefault(src, 0) + 1);
            outdegree.put(dest, outdegree.getOrDefault(dest, 0) - 1);
        }

        int start = -1;
        for (Map.Entry<Integer, Integer> entry : outdegree.entrySet()) {
            if (entry.getValue() > 0) {
                start = entry.getKey();
            }
        }

        if (start == -1) start = pairs[0][0];

        dfs(start);

        int index = 0;
        int[][] result = new int[ans.size()][2];
        while (!ans.isEmpty()) {
            int[] pair = ans.pop();
            result[index][0] = pair[0];
            result[index][1] = pair[1];
            index++;
        }

        return result;
    }

    private static void dfs(int src) {
        while (graph.containsKey(src) && graph.get(src).size() > 0) {
            List<Integer> neighbors = graph.get(src);
            int next = neighbors.get(neighbors.size() - 1);
            graph.get(src).remove(neighbors.size() - 1);

            dfs(next);

            ans.push(new int[]{src, next});
        }
    }
}
