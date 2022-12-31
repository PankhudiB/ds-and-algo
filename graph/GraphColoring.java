package graph;

import java.util.*;

/*
    Pseudo
    maintain :

    availableColors array -> set all to be available
    result array -> set all -1

    set color[src] = some_color (0)

    for all u {
       neighbors = adj[u]
       mark_all_unavailable_colors() ----> loop over all neighbors -> if they are colored(result[v] != -1) -> mark the neighbor's color to be unavailable
       get first available clr
       assign it to color[u]
       RESET all colors to available :)
    }

 */
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

        graph.printArr(graph.paintEfficient(0));

        GraphColoring graph2 = new GraphColoring(5);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 4);
        graph2.addEdge(3, 4);
        graph2.addEdge(0, 3);

        graph.printArr(graph2.paintEfficient(0));

        GraphColoring graph3 = new GraphColoring(3);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(0, 2);

        graph.printArr(graph3.paintEfficient(0));

        GraphColoring graph4 = new GraphColoring(4);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 3);
        graph4.addEdge(3, 0);

        graph.printArr(graph4.paintEfficient(0));
    }

    private int[] paintEfficient(int src) {
        int[] result = new int[noOfVertices];
        boolean[] availableClrs = new boolean[noOfVertices];
        init(result, availableClrs);

        result[src] = 1;

        for (int curr = 1; curr < noOfVertices; curr++) {
            ArrayList<Integer> neighbors = adj.get(curr);
            markUnavailableClrs(result, availableClrs, neighbors);
            result[curr] = getFirstAvailableClr(availableClrs);
            Arrays.fill(availableClrs, true); // RESET
        }
        return result;
    }

    private void markUnavailableClrs(int[] result, boolean[] availableClrs, ArrayList<Integer> neighbors) {
        for (Integer neighbor : neighbors) {
            if (result[neighbor] != -1) {
                availableClrs[result[neighbor]] = false;
            }
        }
    }

    private int getFirstAvailableClr(boolean[] availableClrs) {
        int firstAvailableClr;
        for (firstAvailableClr = 0; firstAvailableClr < noOfVertices; firstAvailableClr++) {
            if (availableClrs[firstAvailableClr]) break;
        }
        return firstAvailableClr;
    }

    private void init(int[] result, boolean[] availableClrs) {
        for (int i = 0; i < noOfVertices; i++) {
            result[i] = -1;
            availableClrs[i] = true;
        }
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
