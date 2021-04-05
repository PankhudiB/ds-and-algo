package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class LongestPathInDAG {
    private int V;
    private ArrayList<ArrayList<AdjNode>> adj;

    static class AdjNode {
        int v, wt;

        public AdjNode(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public LongestPathInDAG(int v) {
        this.V = v;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        LongestPathInDAG g = new LongestPathInDAG(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);
        System.out.println("\nLongestPath In DAG");
        g.findLongestPath(1);
    }

    private void addEdge(int u, int v, int wt) {
        AdjNode node = new AdjNode(v, wt);
        this.adj.get(u).add(node);
    }

    private void findLongestPath(int src) {
        Stack<Integer> stack = new Stack<>();
        int dist[] = new int[V];

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
            dist[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        dist[src] = 0;
        while (!stack.isEmpty()) {
            Integer u = stack.pop();
            if (dist[u] != Integer.MIN_VALUE) {
                for (AdjNode v : adj.get(u)) {
                    if (dist[v.v] < dist[u] + v.wt) {
                        dist[v.v] = dist[u] + v.wt;
                    }
                }
            }
        }
        for (int i = 0; i < V; i++)
            if (dist[i] == Integer.MIN_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
    }


    private void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        for (AdjNode node : adj.get(i)) {
            if (!visited[node.v]) {
                topologicalSortUtil(node.v, visited, stack);
            }
        }
        stack.push(i);
    }
}
