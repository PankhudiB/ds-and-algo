package graph.algos;

public class PrimsAlgoToFindMST {
    private static final int NO_PARENT = -1;
    int noOfVertices;
    boolean[] mstSet;
    int[] distance;
    int[] parent;

    public PrimsAlgoToFindMST(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.distance = new int[noOfVertices];
        this.mstSet = new boolean[noOfVertices];
        this.parent = new int[noOfVertices];
    }

    public static void main(String[] args) {

        /* Let us create the following graph
            2   3
        (0)--(1)--(2)
        |    / \   |
       6|  8/   \5 |7
        |  /     \ |
        (3)-------(4)
              9 */

        int[][] graph = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        // Print the solution
        PrimsAlgoToFindMST p = new PrimsAlgoToFindMST(5);
        p.primMST(graph);
    }

    private void primMST(int[][] graph) {
        initializeDistancesToMaxValue();
        markAllVertexToNotBePartOfMST();
        distance[0] = 0;
        parent[0] = NO_PARENT;

        for (int i = 0; i < noOfVertices - 1; i++) {
            int u = selectMinValueNode();
            mstSet[u] = true;
            for (int v = 0; v < noOfVertices; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < distance[v]) {
                    distance[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
        printMST(graph);
    }

    private void initializeDistancesToMaxValue() {
        for (int i = 0; i < noOfVertices; i++) {
            this.distance[i] = Integer.MAX_VALUE;
        }
    }

    private void markAllVertexToNotBePartOfMST() {
        for (int i = 0; i < noOfVertices; i++) {
            this.mstSet[i] = false;
        }
    }

    private int selectMinValueNode() {
        int min = Integer.MAX_VALUE;
        int vertex = 0;
        for (int i = 0; i < this.distance.length; i++) {
            if (this.distance[i] < min && !this.mstSet[i]) {
                vertex = i;
                min = this.distance[i];
            }
        }
        return vertex;
    }

    void printMST(int graph[][]) {
        System.out.println("Edge \tWeight\n");
        for (int i = 1; i < this.noOfVertices; i++)
            System.out.printf("%d - %d \t%d \n", parent[i], i, graph[i][parent[i]]);
    }
}