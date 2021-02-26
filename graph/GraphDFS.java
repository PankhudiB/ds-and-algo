package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class GraphDFS {
    private int v;
    private ArrayList<Integer> adj[];

    public GraphDFS(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS");
        g.DFS(2);
    }

    private void DFS(int startNode) {
        boolean[] visited = new boolean[this.v];
        DFSUtil(startNode, visited);
    }

    private void DFSUtil(int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");
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
    }
}
