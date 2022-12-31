package graph.algos;

/*
    maintain :
    1. visited arr
    2. distances arr
    3. parent arr

    initialize distances to max value
    mark all vertex to be unvisited

    distance[src] = 0
    parent[src] = no_parent

    for i .. noOfVertices {
        u = select Min distance Unvisited Node
        visited[u] = True
        for all neighbors / for all vertices V {
            if (v not visited && (dist[u] + edge_weight(u,v) < dist[v]))
                update  dist[v] = dist[u] + edge_weight(u,v)
                make u as v's parent --> parent[v] = u
        }
    }

    Result :
        all distances updated in distance arr
        paths from src to each node
            recursively call path func

   path(vertex):
       base condi -> reached parent -> return
       path(parent[vertex])
       print(vertex + " " )

   ===============

   Time Complexity:

   worst case -> O(V^2)

   can be improved -> by using min heap
 */
public class Dijkstra {
    private static final int NO_PARENT = -1;
    int noOfVertices;
    boolean[] visited;
    int[] distances;
    int[] parent;

    public Dijkstra(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        visited = new boolean[noOfVertices];
        distances = new int[noOfVertices];
        parent = new int[noOfVertices];
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix =
                {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                        {4, 0, 8, 0, 0, 0, 0, 11, 0},
                        {0, 8, 0, 7, 0, 4, 0, 0, 2},
                        {0, 0, 7, 0, 9, 14, 0, 0, 0},
                        {0, 0, 0, 9, 0, 10, 0, 0, 0},
                        {0, 0, 4, 0, 10, 0, 2, 0, 0},
                        {0, 0, 0, 14, 0, 2, 0, 1, 6},
                        {8, 11, 0, 0, 0, 0, 1, 0, 7},
                        {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        Dijkstra d = new Dijkstra(adjacencyMatrix.length);
        d.dijkstra(adjacencyMatrix, 0);
    }

    private void dijkstra(int[][] graph, int src) {
        initializeDistancesToMaxValue();
        markAllVertexToNotVisited();

        this.parent[src] = NO_PARENT;
        this.distances[src] = 0;

        for (int i = 0; i < noOfVertices - 1; i++) {
            int u = selectMinDistanceUnvisitedNode();
            this.visited[u] = true;
            for (int v = 0; v < noOfVertices; v++) {
                if (graph[u][v] != 0 && !this.visited[v] && distances[u] != Integer.MAX_VALUE && (this.distances[u] + graph[u][v]) < this.distances[v]) {
                    this.distances[v] = this.distances[u] + graph[u][v];
                    this.parent[v] = u;
                }
            }
        }
        printSolution(src);
    }

    private void initializeDistancesToMaxValue() {
        for (int i = 0; i < noOfVertices; i++) {
            this.distances[i] = Integer.MAX_VALUE;
        }
    }

    private void markAllVertexToNotVisited() {
        for (int i = 0; i < noOfVertices; i++) {
            this.visited[i] = false;
        }
    }

    private int selectMinDistanceUnvisitedNode() {
        int min = Integer.MAX_VALUE;
        int vertex = 0;
        for (int i = 0; i < this.distances.length; i++) {
            if (this.distances[i] < min && !this.visited[i]) {
                vertex = i;
                min = this.distances[i];
            }
        }
        return vertex;
    }

    private void printSolution(int src) {
        for (int vertexIndex = 0; vertexIndex < this.noOfVertices; vertexIndex++) {
            if (vertexIndex != src) {
                System.out.print("\n" + src + " -> " + vertexIndex + " \t\t " + distances[vertexIndex] + " \t\t ");
                printPath(vertexIndex);
            }
        }
    }

    private void printPath(int currVertex) {
        if (currVertex == NO_PARENT) return;
        printPath(this.parent[currVertex]);
        System.out.print(currVertex + " ");
    }
}
