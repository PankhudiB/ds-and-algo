package graph;

import java.util.Arrays;

public class Kruskals {
    int V, E;
    Edge edge[];

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

    class subset {
        int parent;
        int rank;
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
        Edge result[] = new Edge[V-1];
        for (int i = 0; i < V-1; i++) {
            result[i] = new Edge();
        }
        Arrays.sort(edge);
        subset subsets[] = new subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new subset();
        }
        for (int v = 0; v < V; v++) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        int resultItr = 0;
        int edgeItr = 0;
        while (resultItr < V - 1) {
            Edge nextEdge = new Edge();
            nextEdge = edge[edgeItr++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[resultItr++] = nextEdge;
                union(subsets, x, y);
            }
        }

        int minCost = 0;
        for (int i = 0; i < edgeItr-1; i++) {
            System.out.println(result[i].src + "-->" + result[i].dest + " wt: " + result[i].weight);
            minCost += result[i].weight;
        }
        System.out.println("Min cost spanning tree :" + minCost);
    }


    private int find(subset[] subsets, int i) {
        if (subsets[i].parent == i) return i;
        subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    private void union(subset[] subsets, int x, int y) {

        int rootx = this.find(subsets, x);
        int rooty = this.find(subsets, y);

        if (subsets[rootx].rank > subsets[rooty].rank) {
            subsets[rooty].parent = rootx;
        } else if (subsets[rootx].rank < subsets[rooty].rank) {
            subsets[rootx].parent = rooty;
        } else {
            subsets[rooty].parent = rootx;
            subsets[rootx].rank++;
        }
    }
}