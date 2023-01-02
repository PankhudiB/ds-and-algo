package graph.algos;


public class BellmanFord {
    private static final int NO_PARENT = -1;
    int V, E;
    int[] distances;
    int[] parent;

    static class Edge {
        int src, dest, wt;
    }

    static class Graph {
        int V, E;
        Edge edge[];

        public Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }
    }

    public static void main(String[] args) {
        int V = 5, E = 8;
        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].wt = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].wt = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].wt = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].wt = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].wt = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].wt = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].wt = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].wt = -3;

        BellmanFord b = new BellmanFord();
        b.isNegativeCycleBellmanFord(graph, 0);
    }

    /*
    maintain :
    1. dist array
    2. parent array

    the following ensures to give us the shortest path from u -> v -- using all no of edges possible in between u and v

    for i.. noOfVertices :
        for j .. noOfEdges :
            u ---wt---> v
            if ( u != max_int && dist[u] + wt < dist[v] {
                update dist[v] = dist[u] + wt
                update parent[v] = u
            }


    once we have done the above and if we loop again and find if between u and v there is possibility of shorter distance
        if we do --> then definitely we have negative edge weight.

    for i .. noOFEdges :
        u ---wt---> v
        if dist[v] != max_int && dist[u] + wt < dist[v]
            RETURN !!! NEGATIVE EDGE WEIGHT CYCLE FOUND

    TIME COMPLEXITY = O (V * E) 
     */
    private void isNegativeCycleBellmanFord(Graph graph, int src) {
        V = graph.V;
        E = graph.E;
        distances = new int[V];
        parent = new int[V];
        parent[0] = NO_PARENT;

        initializeDistancesToMaxValue();
        this.distances[src] = 0;
        boolean updated = false;
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int wt = graph.edge[j].wt;
                if (distances[u] != Integer.MAX_VALUE && distances[u] + wt < distances[v]) {
                    distances[v] = distances[u] + wt;
                    parent[v] = u;
                    updated = true;
                }
            }
        }

        for (int i = 0; i < E && updated; i++) {
            int u = graph.edge[i].src;
            int v = graph.edge[i].dest;
            int wt = graph.edge[i].wt;
            if (distances[v] != Integer.MAX_VALUE && distances[u] + wt < distances[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printSolution(src);
    }

    private void initializeDistancesToMaxValue() {
        for (int i = 0; i < V; i++) {
            this.distances[i] = Integer.MAX_VALUE;
        }
    }

    private void printSolution(int src) {
        for (int vertexIndex = 0; vertexIndex < this.V; vertexIndex++) {
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
