package graph;

import java.util.ArrayList;

public class FindIfPathMoreThanKLengthFromSource {
    int V;
    ArrayList<ArrayList<AdjListNode>> adj;

    static class AdjListNode {
        int v;
        int weight;

        AdjListNode(int _v, int _w) {
            v = _v;
            weight = _w;
        }

        int getV() {
            return v;
        }

        int getWeight() {
            return weight;
        }
    }

    public FindIfPathMoreThanKLengthFromSource(int v) {
        V = v;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    private void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " : ");
            for (AdjListNode node : adj.get(i)) {
                System.out.print(node.getV() + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FindIfPathMoreThanKLengthFromSource g = new FindIfPathMoreThanKLengthFromSource(7);
/*
               1     5
            0 --> 1 <--  2
            | 5   |6       \*  5
            |*    |*        \
            3 --> 4 --> 5 --> 6
               3     4     2
         */

        g.addEdge(0, 1, 1);
        g.addEdge(0, 3, 5);

        g.addEdge(2, 1, 5);
        g.addEdge(1, 4, 6);

        g.addEdge(6, 2, 5);

        g.addEdge(3, 4, 3);
        g.addEdge(4, 5, 4);
        g.addEdge(5, 6, 2);


        int src = 0;
        int k1 = 13;
        System.out.println(g.pathOfKLengthFromSrc(src, k1));
        int k2 = 50;
        System.out.println(g.pathOfKLengthFromSrc(src, k2));

        FindIfPathMoreThanKLengthFromSource g2 = new FindIfPathMoreThanKLengthFromSource(9);

        // making above shown graph
        g2.addEdge(0, 1, 4);
        g2.addEdge(0, 7, 8);
        g2.addEdge(1, 2, 8);
        g2.addEdge(1, 7, 11);
        g2.addEdge(2, 3, 7);
        g2.addEdge(2, 8, 2);
        g2.addEdge(2, 5, 4);
        g2.addEdge(3, 4, 9);
        g2.addEdge(3, 5, 14);
        g2.addEdge(4, 5, 10);
        g2.addEdge(5, 6, 2);
        g2.addEdge(6, 7, 1);
        g2.addEdge(6, 8, 6);
        g2.addEdge(7, 8, 7);

        int k = 62;
        System.out.println(g2.pathOfKLengthFromSrc(src, k));

        int k3 = 50;
        System.out.println(g2.pathOfKLengthFromSrc(src, k3));

    }

    private void addEdge(int u, int v, int wt) {
        AdjListNode node = new AdjListNode(v, wt);
        adj.get(u).add(node);
    }

    private boolean pathOfKLengthFromSrc(int src, int K) {
        printGraph();
        boolean[] visited = new boolean[V];
        visited[src] = true;
        return pathOfKLengthFromSrcUtil(src, visited, K);
    }

    private boolean pathOfKLengthFromSrcUtil(int curr, boolean[] visited, int K) {
        visited[curr] = true;
        if (K <= 0) {
            return true;
        }

        for (AdjListNode neigh : adj.get(curr)) {
            if (visited[neigh.getV()]) {
                continue;
            }
            if (neigh.getWeight() >= K)
                return true;

            if (pathOfKLengthFromSrcUtil(neigh.getV(), visited, K - neigh.getWeight())) {
                return true;
            }

        }
        visited[curr] = false;
        return false;
    }
}
