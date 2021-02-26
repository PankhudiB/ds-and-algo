package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int v;
    private ArrayList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS");
        g.DFS(2);
        System.out.println("\nBFS");
        g.BFS(2);
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

    private void BFS(int startNode) {
        boolean[] visited = new boolean[this.v];
        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.print(node + " ");

            Iterator<Integer> itr = adj[node].iterator();
            while (itr.hasNext()) {
                Integer neighbour = itr.next();
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }
}
