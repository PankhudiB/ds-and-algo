package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class VertexCover {
    private int V;

    private LinkedList<Integer> adj[];

    VertexCover(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public ArrayList<Integer> printVertexCover() {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        for (int u = 0; u < adj.length; u++) {
            if (!visited[u]) {
                for (Integer v : adj[u]) {
                    if (!visited[v]) {
                        visited[u] = true;
                        visited[v] = true;
                        result.add(u);
                        result.add(v);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        VertexCover g = new VertexCover(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        System.out.println(g.printVertexCover());
    }
}

