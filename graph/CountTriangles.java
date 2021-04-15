package graph;

public class CountTriangles {
    private int V;

    public CountTriangles(int v) {
        V = v;
    }

    public static void main(String args[]) {

        int graph[][] = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };

        int directionalGraph[][] = {
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 1, 0}
        };

        CountTriangles c = new CountTriangles(4);
        System.out.println(c.countTriangels(graph, false));
        System.out.println(c.countTriangels(directionalGraph, true));
    }

    private int countTriangels(int[][] graph, boolean isDirected) {
        int countOfTriangles = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if (graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1) {
                        countOfTriangles++;
                    }
                }
            }
        }

        if (isDirected) countOfTriangles = countOfTriangles / 3;
        else countOfTriangles = countOfTriangles / 6;

        return countOfTriangles;
    }
}

