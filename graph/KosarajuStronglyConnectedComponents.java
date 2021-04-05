package graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuStronglyConnectedComponents {
    private int V;
    private ArrayList<Integer> adj[], transpose[];
    static int time = 0;

    public KosarajuStronglyConnectedComponents(int v) {
        this.V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        transpose = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            transpose[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        KosarajuStronglyConnectedComponents g = new KosarajuStronglyConnectedComponents(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("\nKosaraju SCC : ");
        g.findSCCs();
    }

    private void addEdge(int u, int v) {
        this.adj[u].add(v);
    }

    private void findSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                DFSOnNormalGraph_PopulateStack(i, visited, stack);
        }

        transposeGraph();
        markAllUnvisited(visited);

        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            if (!visited[curr]) {
                DFSOnTransposedGraph(curr, visited);
                System.out.println();
            }
        }
    }

    private void markAllUnvisited(boolean[] visited) {
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
    }

    private void DFSOnNormalGraph_PopulateStack(int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                DFSOnNormalGraph_PopulateStack(v, visited, stack);
            }
        }
        stack.push(u);
    }

    private void DFSOnTransposedGraph(Integer u, boolean[] visited) {
        System.out.print(u + " ");
        visited[u] = true;
        for (int v : transpose[u]) {
            if (!visited[v]) {
                DFSOnTransposedGraph(v, visited);
            }
        }
    }

    private void transposeGraph() {
        for (int i = 0; i < V; i++) {
            for (int j : adj[i]) {
                transpose[j].add(i);
            }
        }
    }


}
