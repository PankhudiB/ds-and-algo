package graph;

public class HamiltonianCycle {
    private static final int NO_PARENT = -1;
    int noOfVertices;
    int[] path;

    public HamiltonianCycle() {
    }

    public static void main(String[] args) {
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int[][] graph1 =
                {{0, 1, 0, 1, 0},
                        {1, 0, 1, 1, 1},
                        {0, 1, 0, 0, 1},
                        {1, 1, 0, 0, 1},
                        {0, 1, 1, 1, 0},};
        HamiltonianCycle d = new HamiltonianCycle();
        System.out.println("HamiltonianCycle for graph1 :");
        d.hamCycle(graph1);

        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };
        System.out.println("HamiltonianCycle for graph2 :");
        d.hamCycle(graph2);

        /* Let us create the following graph
            ------------
            |          |
           (0)--(1)---(2)
            |   /|     |
            |  / |     |
            | /  |     |
           (5)--(4)---(3)    */
        int graph3[][] = {
                {0, 1, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 1, 0},
        };
        System.out.println("HamiltonianCycle for graph3 :");
        d.hamCycle(graph3);
    }

    private void hamCycle(int[][] graph) {
        this.noOfVertices = graph.length;
        path = new int[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            path[i] = -1;
        }
        path[0] = 0;
        hamCycleUtil(graph, path, 1);
    }

    private void hamCycleUtil(int[][] graph, int[] path, int pos) {
        if (pos == noOfVertices) {
            if (graph[path[pos - 1]][path[0]] == 1) {
                printArr(path);
            }
            return;
        }
        for (int v = 1; v < noOfVertices; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                hamCycleUtil(graph, path, pos + 1);
                path[pos] = -1;
            }
        }
    }

    private boolean isSafe(int v, int[][] graph, int[] path, int pos) {
        if (graph[path[pos - 1]][v] == 0) return false;
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) return false;
        }
        return true;
    }

    private void printArr(int[] path) {
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }


}
