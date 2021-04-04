package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class FindStrongConnectedComponentsTarjanAlgo {
    private int V;
    private ArrayList<Integer> adj[];
    static int time = 0;

    public FindStrongConnectedComponentsTarjanAlgo(int v) {
        this.V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        FindStrongConnectedComponentsTarjanAlgo g = new FindStrongConnectedComponentsTarjanAlgo(11);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 0);
        g.addEdge(2, 6);
        g.addEdge(3, 2);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(5, 8);
        g.addEdge(5, 9);
        g.addEdge(6, 4);
        g.addEdge(7, 9);
        g.addEdge(8, 9);
        g.addEdge(9, 8);

        System.out.println("\nTarjan");
        g.tarjan();
    }

    private void addEdge(int u, int v) {
        this.adj[u].add(v);
    }

    private void tarjan() {
        boolean[] isPresentInStack = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        int[] discovery = new int[V];
        int[] low = new int[V];
        for (int i = 0; i < V; i++) {
            low[i] = -1;
            discovery[i] = -1;
            isPresentInStack[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (discovery[i] == -1)
                DFS(i, discovery, low, stack, isPresentInStack);
        }
    }

    private void DFS(int u, int[] discovery, int[] low, Stack<Integer> stack, boolean[] isPresentInStack) {
        discovery[u] = time;
        low[u] = time;
        time++;
        stack.push(u);
        isPresentInStack[u] = true;

        Iterator<Integer> itr = adj[u].iterator();
        while (itr.hasNext()) {
            Integer neigh = itr.next();
            if (discovery[neigh] == -1) {
                DFS(neigh, discovery, low, stack, isPresentInStack);
                low[u] = Math.min(low[u], low[neigh]);
            } else if (isPresentInStack[neigh]) {
                low[u] = Math.min(low[u], discovery[neigh]);
            }
        }
        int w = -1;
        if (low[u] == discovery[u]) {
            while (w != u) {
                w = stack.pop();
                System.out.print(w + " ");
                isPresentInStack[w] = false;
            }
            System.out.println();
        }
    }
}
