package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class NoOfOperationToMakeNetworkConnected {
    private int v;
    private ArrayList<Integer> adj[];

    public static void main(String[] args) {
        NoOfOperationToMakeNetworkConnected g = new NoOfOperationToMakeNetworkConnected();
        int[][] connections = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println("NoOfOperationtoMakeNetworkConnected : " + g.makeConnected(6,connections));

        NoOfOperationToMakeNetworkConnected g2 = new NoOfOperationToMakeNetworkConnected();
        int[][] connections2 = new int[][]{{0,1},{0,2},{3,4},{2,3}};
        System.out.println("NoOfOperationtoMakeNetworkConnected : " + g2.makeConnected(5,connections2));

        NoOfOperationToMakeNetworkConnected g3 = new NoOfOperationToMakeNetworkConnected();
        int[][] connections3 = new int[][]{{0,1},{0,2},{0,3},{1,2}};
        System.out.println("NoOfOperationtoMakeNetworkConnected : " + g3.makeConnected(6,connections3));
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

        int totalEdges = connections.length;
        int noOfComponents = connectedComponents();
        int redundantEdges = totalEdges - ((this.v - 1) - (noOfComponents - 1));
        int noOfOperationstoMakeNetworkConnected = (redundantEdges >= (noOfComponents - 1)) ? (noOfComponents - 1) : -1;
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
