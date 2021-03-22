package graph;

public class UnionFindAlgo {
    int V, E;
    Edge edge[];

    class Edge {
        int src, dest;
    }

    public UnionFindAlgo(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    public static void main(String[] args) {
        int V = 3, E = 3;
        UnionFindAlgo graph = new UnionFindAlgo(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        System.out.println("isCyclic : " + graph.isCyclic());
    }

    private boolean isCyclic() {
        int[] parent = new int[this.V];
        for (int i = 0; i < this.V; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < this.E; i++) {
            int x = this.find(parent, edge[i].src);
            int y = this.find(parent, edge[i].dest);
            if (x == y) return true;

            this.union(parent, x, y);
        }
        return false;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) return i;
        return find(parent, parent[i]);
    }

    private void union(int[] parent, int x, int y) {
        parent[x] = y;
    }
}