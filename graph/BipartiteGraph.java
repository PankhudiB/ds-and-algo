package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    int noOfVertices;
    ArrayList<ArrayList<Integer>> adj;

    public BipartiteGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new ArrayList<>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        BipartiteGraph graph = new BipartiteGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println("IsBipartite : " + graph.isBipartite(0));

        BipartiteGraph graph2 = new BipartiteGraph(5);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 4);
        graph2.addEdge(3, 4);
        graph2.addEdge(0, 3);

        System.out.println("IsBipartite : " + graph2.isBipartite(0));

        BipartiteGraph graph3 = new BipartiteGraph(3);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(0, 2);

        System.out.println("IsBipartite : " + graph3.isBipartite(0));

        BipartiteGraph graph4 = new BipartiteGraph(4);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 3);
        graph4.addEdge(3, 0);

        System.out.println("IsBipartite : " + graph4.isBipartite(0));
    }

    private boolean isBipartite(int src) {
        boolean[] visited = new boolean[noOfVertices];
        int[] resultingClr = new int[noOfVertices];
        int currColor = 1;
        for (int i = 0; i < noOfVertices; i++) {
            resultingClr[i] = -1;
        }
        resultingClr[src] = currColor;
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            Integer curr_vertex = queue.poll();
            Iterator<Integer> itr = adj.get(curr_vertex).iterator();
            while (itr.hasNext()) {
                Integer neighbour = itr.next();
                if (!visited[neighbour]) {
                    if (resultingClr[neighbour] == -1) {
                        resultingClr[neighbour] = 1 - currColor;
                        visited[neighbour] = true;
                        queue.add(neighbour);
                    }
                } else if (visited[neighbour] && resultingClr[neighbour] == resultingClr[curr_vertex]) {
                    return false;
                }
            }
            currColor = 1 - currColor;
        }
        return true;
    }

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
