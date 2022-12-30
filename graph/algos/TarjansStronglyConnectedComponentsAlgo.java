package graph.algos;


import java.util.ArrayList;
import java.util.Stack;

public class TarjansStronglyConnectedComponentsAlgo {
    ArrayList<Integer> adj[];
    int N;
    static int time = 0;
    ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();

    public int printConnectedComponents(int n, int[][] connections) {
        this.N = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int noOfEdges = connections.length;

        for (int[] pair : connections) {
            adj[pair[0]].add(pair[1]);
            adj[pair[1]].add(pair[0]);
        }

        return noOfConnectedComponents();
    }

    private int noOfConnectedComponents() {
        int[] disc = new int[N];
        int[] low = new int[N];
        Stack<Integer> stack = new Stack<>();
        boolean[] inStack = new boolean[N];

        for (int i = 0; i < N; i++) {
            disc[i] = -1;
            low[i] = -1;
            inStack[i] = false;
        }

        for (int i = 0; i < N; i++) {
            if (disc[i] == -1) {
                DFS(i, disc, low, stack, inStack);
            }
        }

        for (ArrayList<Integer> comp : connectedComponents) {
            System.out.println(comp);
        }
        return connectedComponents.size();
    }

    private void DFS(int u, int[] disc, int[] low, Stack<Integer> stack, boolean[] inStack) {
        disc[u] = low[u] = time;
        time++;
        stack.push(u);
        inStack[u] = true;
        for (int v : adj[u]) {
            if (disc[v] == -1) {
                DFS(v, disc, low, stack, inStack);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v] == true) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            System.out.println("found head : " + u);
            ArrayList<Integer> comps = new ArrayList<Integer>();
            while (stack.peek() != u) {
                comps.add(stack.pop());
            }
            comps.add(stack.pop());
            connectedComponents.add(comps);
        }
    }

    public static void main(String[] args) {
        TarjansStronglyConnectedComponentsAlgo t = new TarjansStronglyConnectedComponentsAlgo();
        t.printConnectedComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}});
    }
}
