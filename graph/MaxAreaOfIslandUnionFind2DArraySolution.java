package graph;

// TIP to remember ->
// while doing UF on 2D
// the way you maintain parent and rank --> u can flatten them by
// creating parent & rank arr of size -> noOfRows * noOfCols
// and each cell is represented by (row * noOfCols + col)
// how to calculate max area of islands ?
// maintain size / noOfChildren array
// everytime we do union -> if rootX != rootY
// modify the no of chilren = chilren[x] + children[y];
// notice -? it ll not be += 1
public class MaxAreaOfIslandUnionFind2DArraySolution {
    class UnionFindFor2DArray {
        int[] rank;
        int[] parent;
        int[] noOfChildren;
        int count;

        UnionFindFor2DArray(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            parent = new int[row * col];
            rank = new int[row * col];
            noOfChildren = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        parent[i * col + j] = i * col + j; // -----> becoz we want to flatten and keep row side by side
                        noOfChildren[i * col + j] = 1;
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
                    noOfChildren[rootX] = noOfChildren[rootX] + noOfChildren[rootY];
                } else if (rank[rootY] > rank[rootX]) {
                    parent[rootX] = rootY;
                    noOfChildren[rootY] = noOfChildren[rootX] + noOfChildren[rootY];
                } else {
                    parent[rootY] = rootX;
                    rank[rootX] += 1;
                    noOfChildren[rootX] = noOfChildren[rootX] + noOfChildren[rootY];
                }
            }

        }

        public int maxNoOfChildren() {
            int max = 0;
            for (int i = 0; i < noOfChildren.length; i++) {
                max = Math.max(max, noOfChildren[i]);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIslandUnionFind2DArraySolution uf2D = new MaxAreaOfIslandUnionFind2DArraySolution();

        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };

        System.out.println(uf2D.maxArea(grid));

        char[][] grid2 = new char[][]{
                {'0', '0', '1', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0'},
                {'0', '1', '1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '1', '0', '0', '1', '1', '0', '0', '1', '0', '1', '0', '0'},
                {'0', '1', '0', '0', '1', '1', '0', '0', '1', '1', '1', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0'},
        };
        System.out.println(uf2D.maxArea(grid2));

    }

    public int maxArea(char[][] grid) {
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

        return uf.maxNoOfChildren();
    }
}