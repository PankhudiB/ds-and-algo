package graph;

import java.util.ArrayList;

public class BridgesInGraph {
    private int V;
    private ArrayList<Integer> adj[];
    static int time = 0;

    public BridgesInGraph(int v) {
        this.V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        BridgesInGraph g = new BridgesInGraph(5);
        /*

        1 ----*0 ----* 3 ---* 4
        *\     |
           \   |
             \ *
               2

         */

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        System.out.println("\nBridges in the graph :");
        g.findArticulationPoint();
    }

    private void addEdge(int u, int v) {
        this.adj[u].add(v);
    }

    private void findArticulationPoint() {
        int[] parent = new int[V];
        int[] discovery = new int[V];
        int[] low = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = -1;
            discovery[i] = -1;
            low[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (discovery[i] == -1) {
                DFS(i, discovery, low, parent);
            }
        }
    }

    private void DFS(int u, int[] discovery, int[] low, int[] parent) {
        discovery[u] = time;
        low[u] = time;
        time++;
        for (int v : adj[u]) {
            if (discovery[v] == -1) {   //if v is not visited -> make v child of u
                parent[v] = u;
                DFS(v, discovery, low, parent);
                low[u] = Math.min(low[u], low[v]);

                // if the lowest vertex reachable from subtree under v is below u
                //(i.e its discovery will be much later than u) in DFS tree,
                //then u-v is bridge
                if (low[v] > discovery[u]) {
                    System.out.println(u + " " + v);
                }
            } else if (v != parent[u]) {
                // which means it is an ancestor --> time to update the low value of u
                // ..since looks like an ancestor is accessible
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }
}
