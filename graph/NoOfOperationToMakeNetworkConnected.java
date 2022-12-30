package graph;

import java.util.ArrayList;
import java.util.Iterator;

/*
    In a graph with V nodes -->
        for it to be minimally connected -> we need atleast V-1 edges [E = V-1]

    Similarly when there are M strongly connected components -> you ll need atleast M-1 edges

    1. Find noOfConnectedComponents
    2. To find extra edges with strongly connected components
        extra_edges = Current_no_edges - ( no of vertices - 1 ) - (noOfCC - 1)

        if extra_edges >= (noOfCC - 1)
            return (noOfCC - 1) [in order to use them for bridging rest of network] [Not extra_edges - becoz we want to minimally connect the graph]
        else
            there are not sufficient extra edges



    Time complexity = time to find noOfCC
        O(V+E) -> for DFS
        DFS on all nodes --> V * (V+E)
        total = O(V * (V+E))
 */
public class NoOfOperationToMakeNetworkConnected {
    private int v;
    private ArrayList<Integer> adj[];

    public static void main(String[] args) {
        NoOfOperationToMakeNetworkConnected g = new NoOfOperationToMakeNetworkConnected();
        int[][] connections = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println("NoOfOperationtoMakeNetworkConnected : " + g.makeConnected(6, connections));

        NoOfOperationToMakeNetworkConnected g2 = new NoOfOperationToMakeNetworkConnected();
        int[][] connections2 = new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        System.out.println("NoOfOperationtoMakeNetworkConnected : " + g2.makeConnected(5, connections2));

        NoOfOperationToMakeNetworkConnected g3 = new NoOfOperationToMakeNetworkConnected();
        int[][] connections3 = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        System.out.println("NoOfOperationtoMakeNetworkConnected : " + g3.makeConnected(6, connections3));
    }

    public int makeConnected(int n, int[][] connections) {
        this.v = n;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            this.addEdge(connection[0], connection[1]);
        }

        int currEdges = connections.length;
        int noOfCC = connectedComponents();
        int extraEdges = currEdges - ((n - 1) - (noOfCC - 1));
        int noOfOperationstoMakeNetworkConnected = (extraEdges >= (noOfCC - 1)) ? (noOfCC - 1) : -1;
        return noOfOperationstoMakeNetworkConnected;
    }

    private int connectedComponents() {
        int noOfComponents = 0;
        boolean[] visited = new boolean[this.v];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                noOfComponents++;
            }
        }
        return noOfComponents;
    }

    private void DFSUtil(int curr, boolean[] visited) {
        visited[curr] = true;
        Iterator<Integer> itr = adj[curr].iterator();
        while (itr.hasNext()) {
            Integer adjacentNode = itr.next();
            if (!visited[adjacentNode]) {
                DFSUtil(adjacentNode, visited);
            }
        }
    }

    private void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
    }
}
