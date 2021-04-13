package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class MinReversalOfEdgesToReachDest {
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

    class Graph {
        int V;
        ArrayList<ArrayList<AdjListNode>> adj;

        public Graph(int v) {
            V = v;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        int edge[][] = {{0, 1}, {2, 1},
                {2, 3}, {5, 1},
                {4, 5}, {6, 4},
                {6, 3}};
        int E = edge.length;

        MinReversalOfEdgesToReachDest d = new MinReversalOfEdgesToReachDest();
        int src = 0;
        int dest = 6;
        System.out.println(d.minReversalToReachDest(edge, E, V, src, dest));
    }

    private int minReversalToReachDest(int[][] edge, int E, int V, int src, int dest) {
        Graph graph = modelGraphWithEdgeWeight(edge, E, V);
        printGraph(graph);
        boolean[] processed = new boolean[graph.V];
        int[] distances = new int[graph.V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(processed, false);
        distances[src] = 0;
        int noOfReversal = 0;
        for (int i = 0; i < graph.V - 1; i++) {
            int u = selectMinValueNode(distances, processed);
            processed[u] = true;
            for (AdjListNode neigh : graph.adj.get(u)) {
                if (neigh.v == dest) {
                    return noOfReversal;
                }
                if (!processed[neigh.v] && distances[u] != Integer.MAX_VALUE && distances[u] + neigh.weight < distances[neigh.v]) {
                    distances[neigh.v] = distances[u] + neigh.weight;
                    noOfReversal += neigh.weight;
                }
            }
        }
        return noOfReversal;
    }

    private void printGraph(Graph graph) {
        for (int i = 0; i < graph.V; i++) {
            System.out.print(i + "[ ");
            for (AdjListNode neigh : graph.adj.get(i)) {
                System.out.print(neigh.v + ": " + neigh.weight + " ,");
            }
            System.out.println("]");
        }

    }

    private int selectMinValueNode(int[] distances, boolean[] processed) {
        int min = Integer.MAX_VALUE;
        int vertex = 0;
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] < min && !processed[i]) {
                vertex = i;
                min = distances[i];
            }
        }
        return vertex;
    }

    private Graph modelGraphWithEdgeWeight(int[][] edges, int e, int v) {
        Graph g = new Graph(v);
        for (int[] edge : edges) {
            AdjListNode original = new AdjListNode(edge[1], 0);
            g.adj.get(edge[0]).add(original);
            AdjListNode reversed = new AdjListNode(edge[0], 1);
            g.adj.get(edge[1]).add(reversed);
        }
        return g;
    }

}
