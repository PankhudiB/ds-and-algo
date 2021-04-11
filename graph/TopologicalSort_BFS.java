package graph;

import java.util.*;

public class TopologicalSort_BFS {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    TopologicalSort_BFS(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public static void main(String[] args) {
        TopologicalSort_BFS t = new TopologicalSort_BFS(6);
        /*


              5
              |  \
              |*  \*
        3 <---0--> 2
        |         /*
        |*       /
        1 <--- 4
         */

        t.addEdge(0, 2);
        t.addEdge(0, 3);
        t.addEdge(3, 1);
        t.addEdge(4, 1);
        t.addEdge(4, 2);
        t.addEdge(5, 2);
        t.addEdge(5, 0);
        System.out.println(t.topoSort());
    }

    private ArrayList<Integer> topoSort() {
        int[] indegree = new int[V];
        ArrayList<Integer> toposorted = new ArrayList<>();
        for (int u = 0; u < adj.size(); u++) {
            System.out.print("for u " + u + " :");
            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i);
                indegree[v]++;
                System.out.print(v + ":" + indegree[v] + ",");
            }
            System.out.println();
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Integer polled = queue.poll();
            toposorted.add(polled);

            for (Integer neigh : adj.get(polled)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
            count++;
        }

        if (count != V) {
            System.out.println("there exists a cycle");
        }
        return toposorted;
    }
}