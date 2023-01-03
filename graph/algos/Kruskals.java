package graph.algos;

import java.util.Arrays;

/*
    Intent -> find MST

    underlying Uses Union-Find

    1. Sort all edges available
    2. init union-find --> (make everyone parent of themselves + set all rank =0)
    3. pick all edges 1 by 1:
        in an edge -> u --> v
            x = find(u)
            y = find(v)

            if(x!=y) // if they are not already connected
                add this edge to result
                union(u,v)

    4. mstCost = 0
    5. result array has the edges that form MST - use this to calculate MST
 */
public class Kruskals {
    int V, E;
    Edge edge[];
    int[] parent;
    int[] rank;

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public Kruskals(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    public static void main(String[] args) {
        /*
                   10
                0--------1
                |  \     |
               6|   5\   |15
                |      \ |
                2--------3
                     4       */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Kruskals graph = new Kruskals(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        // Function call
        graph.KruskalMST();
    }

    private void KruskalMST() {
        Edge[] result = initResultEdges();

        Arrays.sort(edge);

        initParentAndRank();

        int resultItr = 0;
        int edgeItr = 0;
        while (resultItr < V - 1) {
            Edge nextEdge = edge[edgeItr++];

            int x = find(nextEdge.src);
            int y = find(nextEdge.dest);

            if (x != y) {
                result[resultItr++] = nextEdge;
                union(x, y);
            }
        }

        int minCost = 0;
        for (int i = 0; i < edgeItr - 1; i++) {
            System.out.println(result[i].src + "-->" + result[i].dest + " wt: " + result[i].weight);
            minCost += result[i].weight;
        }
        System.out.println("Min cost spanning tree :" + minCost);
    }

    private void initParentAndRank() {
        parent = new int[V];
        rank = new int[V];
        for (int v = 0; v < V; v++) {
            parent[v] = v;
            rank[v] = 0;
        }
    }

    private Edge[] initResultEdges() {
        Edge result[] = new Edge[V - 1];
        for (int i = 0; i < V - 1; i++) {
            result[i] = new Edge();
        }
        return result;
    }

    private int find(int i) {
        if (parent[i] == i) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }

    private void union(int x, int y) {

        int rootx = this.find(x);
        int rooty = this.find(y);

        if (rank[rootx] > rank[rooty]) {
            parent[rooty] = rootx;
        } else if (rank[rootx] < rank[rooty]) {
            parent[rootx] = rooty;
        } else {
            parent[rooty] = rootx;
            rank[rootx]++;
        }
    }
}