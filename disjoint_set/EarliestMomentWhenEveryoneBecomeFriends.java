package disjoint_set;

import java.util.Arrays;
import java.util.Comparator;

public class EarliestMomentWhenEveryoneBecomeFriends {

    public static void main(String[] args) {
        int[][] logs = new int[][]{{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}};
        System.out.println(earliestAcq(logs, 6));

        int[][] logs2 = new int[][]{{0, 2, 0}, {1, 0, 1}, {3, 0, 3}, {4, 1, 2}, {7, 3, 1}};
        System.out.println(earliestAcq(logs2, 4));

        int[][] logs3 = new int[][]{{9, 3, 0}, {0, 2, 1}, {8, 0, 1}, {1, 3, 2}, {2, 2, 0}, {3, 3, 1}};
        System.out.println(earliestAcq(logs3, 4));

        int[][] logs4 = new int[][]{{0, 2, 0}, {7, 4, 3}, {2, 2, 1}, {1, 0, 1}, {5, 4, 1}, {6, 3, 2}, {8, 3, 1}, {3, 0, 4}};
        System.out.println(earliestAcq(logs4, 5));

        int[][] logs5 = new int[][]{{9, 0, 3}, {0, 2, 7}, {12, 3, 1}, {5, 5, 2}, {3, 4, 5}, {1, 5, 0}, {6, 2, 4}, {2, 5, 3}, {7, 7, 3}};
        System.out.println(earliestAcq(logs5, 8));

    }

    public static int earliestAcq(int[][] logs, int n) {

        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));

        int[] root = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        int components = n;
        int i = 0;
        while (components > 1 && i < logs.length) {
            components -= union(root, rank, logs[i][1], logs[i][2]);
            i++;
        }

        return components == 1 ? logs[i - 1][0] : -1;
    }

    private static int find(int[] root, int x) {
        if (x == root[x]) return x;
        return root[x] = find(root, root[x]);
    }

    private static int union(int[] root, int[] rank, int x, int y) {
        int rootx = find(root, x);
        int rooty = find(root, y);

        if (rootx == rooty) return 0;
        else {
            if (rank[rootx] > rank[rooty]) {
                rank[rootx] += rank[rooty];
                root[rooty] = rootx;
            } else {
                rank[rooty] += rank[rootx];
                root[rootx] = rooty;
            }
            return 1;
        }
    }
}