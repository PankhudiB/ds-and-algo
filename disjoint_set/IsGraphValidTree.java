package disjoint_set;

public class IsGraphValidTree {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 4}, {1, 4}, {2, 3}};
        System.out.println("expected : false | Got : " + isGraphValidTree(5, edges));
        int[][] edges2 = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println("expected : true | Got : " + isGraphValidTree(5, edges2));
    }

    public static boolean isGraphValidTree(int n, int[][] edges) {
        int noOfEdges = edges.length;
        if (noOfEdges != n - 1) return false;

        int[] root = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < noOfEdges; i++) {
            if (isConnected(root, edges[i][0], edges[i][1])) return false;
            else union(root, rank, edges[i][0], edges[i][1]);
        }
        return true;
    }

    public static int find(int[] root, int x) {
        if (x == root[x]) return x;
        return root[x] = find(root, root[x]);
    }

    public static void union(int[] root, int[] rank, int x, int y) {
        int rootX = find(root, x);
        int rootY = find(root, y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public static boolean isConnected(int[] root, int x, int y) {
        return root[x] == root[y];
    }
}