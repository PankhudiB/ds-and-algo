package disjoint_set;

public class UnionAndFind {
    int[] root;

    public void UnionAndFind(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
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

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
