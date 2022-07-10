package graph.algos;

import java.util.ArrayList;

public class AdjacencyListRepresentation {

    public static void main(String[] args) {
        int noOfVertices = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) {
            graph.add(new ArrayList<Integer>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        printGraph(graph);
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("adj list for vertex :" + i);
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print("-->" + graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
}
