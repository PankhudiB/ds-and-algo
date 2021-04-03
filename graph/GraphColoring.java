package graph;

import java.util.*;

public class GraphColoring {
    int noOfVertices;
    ArrayList<ArrayList<Integer>> adj;

    public GraphColoring(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new ArrayList<>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        GraphColoring graph = new GraphColoring(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.printArr(graph.paint(0));

        GraphColoring graph2 = new GraphColoring(5);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 4);
        graph2.addEdge(3, 4);
        graph2.addEdge(0, 3);

        graph.printArr(graph2.paint(0));

        GraphColoring graph3 = new GraphColoring(3);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(0, 2);

        graph.printArr(graph3.paint(0));

        GraphColoring graph4 = new GraphColoring(4);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 3);
        graph4.addEdge(3, 0);

        graph.printArr(graph4.paint(0));
    }

    private int[] paint(int src) {
        int[] result = new int[noOfVertices];
        boolean[] available = new boolean[noOfVertices];
        int currColor = 1;
        for (int i = 0; i < noOfVertices; i++) {
            result[i] = -1;
            available[i] = true;
        }
        result[src] = currColor;
        for (int curr = 1; curr < noOfVertices; curr++) {
            Iterator<Integer> itr = adj.get(curr).iterator();
            while (itr.hasNext()) {
                Integer neighbour = itr.next();
                if (result[neighbour] != -1) {
                    available[result[neighbour]] = false;
                }
            }
            int firstAvailableClr;
            for (firstAvailableClr = 0; firstAvailableClr < noOfVertices; firstAvailableClr++) {
                if (available[firstAvailableClr]) break;
            }
            result[curr] = firstAvailableClr;
            Arrays.fill(available, true);
        }
        return result;
    }

    private int[] paintEfficient(int src) {
        int[] result = new int[noOfVertices];
        boolean[] available = new boolean[noOfVertices];
        int currColor = 1;
        for (int i = 0; i < noOfVertices; i++) {
            result[i] = -1;
            available[i] = true;
        }
        result[src] = currColor;
        for (int curr = 1; curr < noOfVertices; curr++) {
            Iterator<Integer> itr = adj.get(curr).iterator();
            while (itr.hasNext()) {
                Integer neighbour = itr.next();
                if (result[neighbour] != -1) {
                    available[result[neighbour]] = false;
                }
            }
            int firstAvailableClr;
            for (firstAvailableClr = 0; firstAvailableClr < noOfVertices; firstAvailableClr++) {
                if (available[firstAvailableClr]) break;
            }
            result[curr] = firstAvailableClr;
            Arrays.fill(available, true);
        }
        return result;
    }

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
