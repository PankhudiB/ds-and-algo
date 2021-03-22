package graph;

public class UnionFindByRankAndPathCompression {
    int V, E;
    Edge edge[];

    class Edge {
        int src, dest;
    }

    public UnionFindByRankAndPathCompression(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    class subset {
        int parent;
        int rank;
    }

    public static void main(String[] args) {
        int V = 3, E = 3;
        UnionFindByRankAndPathCompression graph = new UnionFindByRankAndPathCompression(V, E);

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
        subset[] subsets = new subset[this.V];
        for (int i = 0; i < this.V; i++) {
            subsets[i] = new subset();
            subsets[i].parent = -1;
            subsets[i].rank = 0;
        }
        for (int i = 0; i < this.E; i++) {
            int x = this.find(subsets, edge[i].src);
            int y = this.find(subsets, edge[i].dest);
            if (x == y) return true;

            this.union(subsets, x, y);
        }
        return false;
    }

    private int find(subset[] subsets, int i) {
        if (subsets[i].parent == -1) return i;
        subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    private void union(subset[] subsets, int x, int y) {

        int rootx = this.find(subsets, x);
        int rooty = this.find(subsets, y);

        if (subsets[rootx].rank > subsets[rooty].rank) {
            subsets[rooty].parent = rootx;
        } else if (subsets[rootx].rank < subsets[rooty].rank) {
            subsets[rootx].parent = rooty;
        } else {
            subsets[rooty].parent = rootx;
            subsets[rootx].rank++;
        }
    }
}