package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class DetectCycleInDirectectedGraphUsingColor {
    private int v;
    private ArrayList<Integer> adj[];
    static int WHITE = 0, GRAY = 1, BLACK = 2;

    public DetectCycleInDirectectedGraphUsingColor(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        //             0
        //          /     \
        //         1        2
        //                /    \
        //              4       3
        //                 \       \
        //                    ---   5


        DetectCycleInDirectectedGraphUsingColor graph = new DetectCycleInDirectectedGraphUsingColor(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 2);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);

        System.out.println("DFS");
        System.out.println("isCyclic : " + graph.isCyclic(0));

        DetectCycleInDirectectedGraphUsingColor graph2 = new DetectCycleInDirectectedGraphUsingColor(5);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(2, 4);

        System.out.println("isCyclic : " + graph2.isCyclic(2));

        DetectCycleInDirectectedGraphUsingColor graph3 = new DetectCycleInDirectectedGraphUsingColor(3);
        graph3.addEdge(0, 1);
        graph3.addEdge(0, 2);
        graph3.addEdge(2, 2);

        System.out.println("isCyclic : " + graph3.isCyclic(0));

        DetectCycleInDirectectedGraphUsingColor graph4 = new DetectCycleInDirectectedGraphUsingColor(2);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 0);

        System.out.println("isCyclic : " + graph4.isCyclic(0));
    }

    private boolean isCyclic(int startNode) {
        int[] color = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = WHITE;
        }

        for (int i = 0; i < v; i++) {
            if (color[i] == WHITE) {
                if (isCyclicUtil(i, color))
                    return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int curr, int[] color) {
        color[curr] = GRAY;
        for (Integer neighbor : adj[curr]) {
            if (color[neighbor] == GRAY) return true;
            if (color[neighbor] == WHITE) {
                if (isCyclicUtil(neighbor, color)) {
                    return true;
                }
            }
        }
        color[curr] = BLACK;
        return false;
    }

    private void addEdge(int u, int v) {
        this.adj[u].add(v);
    }
}
