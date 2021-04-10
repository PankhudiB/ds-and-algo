package graph;


import util.Tuple;

import java.util.HashMap;

class CheapestFlightWithKStops_Memoization {
    private HashMap<Tuple<Integer, Integer>, Long> memo;
    int[][] adjMatrix;

    public static void main(String[] args) {
        CheapestFlightWithKStops_Memoization c = new CheapestFlightWithKStops_Memoization();
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(c.findCheapestPrice(3, flights, 0, 2, 1));

        /*              5       1
                   0  ----* 1 ---* 4
                   |    /*   |    /*
                   |2  /2    |5  /1
                   |* /      |* /
                   3          2

        */

        int[][] flights2 = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        System.out.println(c.findCheapestPrice(5, flights2, 0, 2, 2));

        int[][] flights3 = {{0, 3, 3}, {3, 4, 3}, {4, 1, 3}, {0, 5, 1}, {5, 1, 100}, {0, 6, 2}, {6, 1, 100}, {0, 7, 1}, {7, 8, 1}, {8, 9, 1}, {9, 1, 1}, {1, 10, 1}, {10, 2, 1}, {1, 2, 100}};
        System.out.println(c.findCheapestPrice(11, flights3, 0, 2, 4));

    }

    private int findCheapestPrice(int n, int[][] flights, int src, int dest, int K) {
        this.memo = new HashMap<>();
        adjMatrix = new int[n][n];
        for (int[] flight : flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }
        long ans = findShortest(src, dest, K, n);
        return ans == Integer.MAX_VALUE ? -1 : (int) ans;
    }

    private long findShortest(int node, int dest, int stopsTowardsDest, int n) {
        if (node == dest) return 0; //dest to dest will always be 0 -> no self loop :P

        if (stopsTowardsDest < 0) return Integer.MAX_VALUE;

        Tuple<Integer, Integer> key = new Tuple<>(node, stopsTowardsDest);

        if (this.memo.containsKey(key)) {
            return memo.get(key);
        }

        long ans = Integer.MAX_VALUE;
        for (int neigh = 0; neigh < n; neigh++) {
            int weight = adjMatrix[node][neigh];

            if (weight > 0) {
                ans = Math.min(ans, findShortest(neigh, dest, stopsTowardsDest - 1, n) + weight);
            }
        }
        this.memo.put(key, ans);
        return ans;
    }
}