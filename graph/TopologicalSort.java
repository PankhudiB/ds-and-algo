package graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    TopologicalSort(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public static void main(String[] args) {
        TopologicalSort t = new TopologicalSort(6);
        t.addEdge(0, 2);
        t.addEdge(0, 3);
        t.addEdge(3, 1);
        t.addEdge(4, 1);
        t.addEdge(4, 2);
        t.addEdge(5, 2);
        t.addEdge(5, 0);
        System.out.println(t.topoSort());
    }

    private int[] topoSort() {
        int[] result = new int[this.V];
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[this.V];
        for (int u = 0; u < this.V; u++) {
            if (!visited[u]) {
                topoSortUtil(u, visited, stack);
            }
        }
        for (int i = 0; i < this.V; i++) {
            result[i] = stack.pop();
            System.out.print(result[i] + " ");
        }
        return result;
    }

    private void topoSortUtil(int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                topoSortUtil(v, visited, stack);
            }
        }
        stack.push(u);
    }
}