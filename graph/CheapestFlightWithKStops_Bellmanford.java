package graph;


import java.util.Arrays;

class CheapestFlightWithKStops_Bellmanford {

    public static void main(String[] args) {
        CheapestFlightWithKStops_Bellmanford c = new CheapestFlightWithKStops_Bellmanford();
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
        long[][] distances = new long[2][n];
        Arrays.fill(distances[0], Integer.MAX_VALUE);
        Arrays.fill(distances[1], Integer.MAX_VALUE);
        distances[0][src] = distances[1][src] = 0;

        for (int interations = 0; interations < K + 1; interations++) {
            for (int[] edge : flights) {
                int u = edge[0];
                int v = edge[1];
                int weightUV = edge[2];

                int currentArray = interations & 1;
                int previousArray = 1 - interations & 1;

                long distanceOfU = distances[previousArray][u];
                long distanceOfV = distances[currentArray][v];

                if (distanceOfU + weightUV < distanceOfV) {
                    distances[currentArray][v] = distanceOfU + weightUV;
                }
            }
        }
        return distances[K & 1][dest] < Integer.MAX_VALUE ? (int) distances[K & 1][dest] : -1;
    }
}