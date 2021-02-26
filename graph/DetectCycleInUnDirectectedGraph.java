package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class DetectCycleInUnDirectectedGraph {
    private int v;
    private ArrayList<Integer> adj[];

    public DetectCycleInUnDirectectedGraph(int v) {
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


        DetectCycleInUnDirectectedGraph graph = new DetectCycleInUnDirectectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 2);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);

        System.out.println("DFS");
        System.out.println("isCyclic : " + graph.isCyclic(0));

        DetectCycleInUnDirectectedGraph graph2 = new DetectCycleInUnDirectectedGraph(5);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(2, 4);

        System.out.println("isCyclic : " + graph2.isCyclic(2));
    }

    private boolean isCyclic(int startNode) {
        boolean[] visited = new boolean[this.v];
        return DFSUtil(startNode, visited, -1);
    }

    private boolean DFSUtil(int curr, boolean[] visited, int parent) {
        visited[curr] = true;
        System.out.print(curr + " ");
        Iterator<Integer> itr = adj[curr].iterator();
        while (itr.hasNext()) {
            Integer adjacentNode = itr.next();
            if (!visited[adjacentNode]) {
                boolean isCyclic = DFSUtil(adjacentNode, visited, curr);
                if (isCyclic) return true;
            } else if (adjacentNode != parent) {
                return true;
            }
        }
        return false;
    }

    private void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
    }
}
