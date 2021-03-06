package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class DetectCycleInDirectectedGraph {
    private int v;
    private ArrayList<Integer> adj[];

    public DetectCycleInDirectectedGraph(int v) {
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


        DetectCycleInDirectectedGraph graph = new DetectCycleInDirectectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 2);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);

        System.out.println("DFS");
        System.out.println("isCyclic : " + graph.isCyclic(0));

        DetectCycleInDirectectedGraph graph2 = new DetectCycleInDirectectedGraph(5);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(2, 4);

        System.out.println("isCyclic : " + graph2.isCyclic(2));

        DetectCycleInDirectectedGraph graph3 = new DetectCycleInDirectectedGraph(3);
        graph3.addEdge(0, 1);
        graph3.addEdge(0, 2);
        graph3.addEdge(2, 2);

        System.out.println("isCyclic : " + graph3.isCyclic(0));

        DetectCycleInDirectectedGraph graph4 = new DetectCycleInDirectectedGraph(2);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 0);

        System.out.println("isCyclic : " + graph4.isCyclic(0));
    }

    private boolean isCyclic(int startNode) {
        boolean[] visited = new boolean[this.v];
        boolean[] recStack = new boolean[this.v];
        for (int i = 0; i < v; i++) {
            if (isCyclicUtil(startNode, visited, recStack))
                return true;
        }
        return false;
    }

    private boolean isCyclicUtil(int curr, boolean[] visited, boolean[] recStack) {
        if (recStack[curr]) return true;
        if (visited[curr]) return false;

        visited[curr] = true;
        recStack[curr] = true;

        Iterator<Integer> itr = adj[curr].iterator();
        while (itr.hasNext()) {
            Integer adjacentNode = itr.next();
            if (isCyclicUtil(adjacentNode, visited, recStack))
                return true;

        }
        recStack[curr] = false;
        return false;
    }

    private void addEdge(int u, int v) {
        this.adj[u].add(v);
    }
}
