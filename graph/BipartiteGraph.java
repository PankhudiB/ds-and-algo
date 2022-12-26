package graph;

import java.util.*;

/*

    U      V
    1      5
    2      4
    3      6

there will be edges from u -> v OR v -> u
but not within V OR within U

    A Bipartite Graph is a graph whose vertices
    can be divided into two independent sets, U and V
    such that every edge (u, v) either connects a vertex from U to V
     or a vertex from V to U


    if no disconnected components in graph

    maintain
    color array -> keep filling colors
    visited array

    BFS or DFS
        if visited
            color[u] == color[neighbor] --> return false -> not bipartite - there is cycle with the set
        else
            time to color              
            if u is white (1)
                then neighbors of u --> black (0) [1 - color[u]]
            

 */

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

    //works for only connected graph
    private boolean isBipartite(int src) {
        boolean[] visited = new boolean[noOfVertices];
        int[] resultingClr = new int[noOfVertices];
        int currColor = 1;
        initColors(resultingClr, -1);
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

    //
    private boolean isBipartiteAgain(int src) {

        int[] color = new int[noOfVertices];
        initColors(color, -1);
        boolean[] visited = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) { // to make it work for disconnected graph
            if (color[i] == -1) {
                if (BFS(color, visited, i) == false) return false;
            }
        }
        System.out.println(Arrays.toString(color));
        return true;
    }

    private boolean BFS(int[] color, boolean[] visited, int i) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.add(i);
        color[i] = 1;
        while (!q.isEmpty()) {
            Integer currNode = q.poll();
            ArrayList<Integer> neighbors = adj.get(currNode);

            for (int neighbor : neighbors) {
                if (visited[neighbor]) {
                    if (color[currNode] == color[neighbor]) {
                        return false;
                    }
                } else {
                    q.add(neighbor);
                    color[neighbor] = 1 - color[currNode];
                    visited[neighbor] = true;
                }
            }
        }
        return true;
    }

    private void initColors(int[] color, int k) {
        for (int i = 0; i < noOfVertices; i++) {
            color[i] = k;
        }
    }

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
