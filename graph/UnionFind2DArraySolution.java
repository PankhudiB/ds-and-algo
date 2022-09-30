package graph;

// TIP to remember ->
// while doing UF on 2D
// the way you maintain parent and rank --> u can flatten them by
// creating parent & rank arr of size -> noOfRows * noOfCols
// and each cell is represented by (row * noOfCols + col)
// how to calculate no of islands ?
// everytime during union -> if the roots are not same --> reduce the count

public class UnionFind2DArraySolution {
    class UnionFindFor2DArray {


        int[] rank;
        int[] parent;
        int count;

        UnionFindFor2DArray(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            parent = new int[row * col];
            rank = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        parent[i * col + j] = i * col + j; // -----> becoz we want to flatten and keep row side by side
                    }
                    rank[i * col + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootY] > rank[rootX]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX] += 1;
                }
                this.count--;
            }
        }

        public int getCount() {
            return this.count;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };

        UnionFind2DArraySolution uf2D = new UnionFind2DArraySolution();
        System.out.println(uf2D.noOfIslands(grid));
    }

    public int noOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        UnionFindFor2DArray uf = new UnionFindFor2DArray(grid);

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * nc + c, r * nc + (c - 1));
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        uf.union(r * nc + c, r * nc + (c + 1));
                    }
                }
            }
        }
        return uf.getCount();
    }
}