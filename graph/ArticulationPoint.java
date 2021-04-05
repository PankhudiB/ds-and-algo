package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ArticulationPoint {
    private int V;
    private ArrayList<Integer> adj[];
    static int time = 0;

    public ArticulationPoint(int v) {
        this.V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        ArticulationPoint g = new ArticulationPoint(5);
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
        System.out.println("\nArticulation Points in the graph :");
        g.findArticulationPoint();
    }

    private void addEdge(int u, int v) {
        this.adj[u].add(v);
    }

    private void findArticulationPoint() {
        int[] parent = new int[V];
        int[] discovery = new int[V];
        int[] low = new int[V];
        boolean[] articulationPoints = new boolean[V];
        for (int i = 0; i < V; i++) {
            parent[i] = -1;
            discovery[i] = -1;
            low[i] = -1;
            articulationPoints[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (discovery[i] == -1) {
                DFS(i, discovery, low, parent, articulationPoints);
            }
        }

        for (int i = 0; i < V; i++) {
            if (articulationPoints[i]) System.out.print(i + " ");
        }
    }

    private void DFS(int u, int[] discovery, int[] low, int[] parent, boolean[] articulationPoints) {
        discovery[u] = time;
        low[u] = time;
        time++;
        int children = 0;
        for (int v : adj[u]) {
            if (discovery[v] == -1) {   //if v is visited
                parent[v] = u;
                children++;
                DFS(v, discovery, low, parent, articulationPoints);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1) {     // if u is root node & has more than 1 subgraph. then it is bound to be an AP
                    articulationPoints[u] = true;
                }
                if (parent[u] != -1 && low[v] > discovery[u]) {
                    // if u is not root. then see if any v(child) have higher low value than disc of u
                    // i.e if u is not root node. then there should be atleast be 1 subgraph
                    //which does not have a backedge to any of the ancestor
                    articulationPoints[u] = true;
                }
            } else if (v != parent[u]) {
                // which means it is an ancestor --> time to update the low value of u
                // ..since looks like an ancestor is accessible
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }
}
