package disjoint_set;

public class UnionAndFind {
    int[] rank;
    int[] root;

    public void UnionAndFind(int n) {
        rank = new int[n];
        root = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            root[rootY] = rootX;
        }

    }

    public int findWithPathCompression(int x) {
        if (x == root[x]) return x;
        return root[x] = findWithPathCompression(root[x]);
    }

    public void unionWithRank(int x, int y) {
        int rootX = findWithPathCompression(x);
        int rootY = findWithPathCompression(y);

        if (rootX != rootY) {
            if (rank[x] > rank[y]) {
                root[y] = rootX;
            } else if (rank[y] > rank[x]) {
                root[x] = rootY;
            } else {
                root[y] = rootX;
                rank[y]++;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
