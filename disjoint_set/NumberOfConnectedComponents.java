package disjoint_set;

public class NumberOfConnectedComponents {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {0, 2}, {3, 4}};
        System.out.println(countComponents(5, edges));

        int[][] edges2 = new int[][]{{0, 1}, {1, 2}, {0, 2}, {2, 3}, {3, 4}};
        System.out.println(countComponents(5, edges2));

        int[][] edges3 = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(5, edges3));
    }

    public static int countComponents(int n, int[][] edges) {
        int noOfEdges = edges.length;
        int[] root = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }

        int components = n;
        for (int i = 0; i < noOfEdges; i++) {
            components -= union(root, rank, edges[i][0], edges[i][1]);
        }

        return components;
    }

    private static int find(int[] root, int x) {
        if (x == root[x]) return x;
        return find(root, root[x]);
    }

    private static int union(int[] root, int[] rank, int x, int y) {
        int rootX = find(root, x);
        int rootY = find(root, y);

        if (rootX == rootY) return 0;
        else {
            if (rank[rootX] > rank[rootY]) {
                rank[rootX] += rank[rootY];
                root[rootY] = rootX;
            } else {
                rank[rootY] += rank[rootX];
                root[rootX] = rootY;
            }
            return 1;
        }
    }
}

/*
    initially components = n vertices ;
    decrement if union is - actually joining 2 set of diff components .
        during union - if x and y are already connected -> then x & y are both part of same set
            no need to decrement components
*/