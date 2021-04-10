package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

class CheapestFlightWithKStops {

    public static void main(String[] args) {
        CheapestFlightWithKStops c = new CheapestFlightWithKStops();
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
        int[][] adjMatrix = new int[n][n];
        for (int[] flight : flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        int[] currStops = new int[n];
        Arrays.fill(currStops, Integer.MAX_VALUE);
        currStops[src] = 0;

        PriorityQueue<Triplet> minHeap = new PriorityQueue<>((a, b) -> (a.stops - b.stops) * 100000 + a.cost - b.cost);
        minHeap.offer(new Triplet(src, 0, 0));

        while (!minHeap.isEmpty()) {
            Triplet curr = minHeap.poll();

            if (curr.stops == K + 1) {
                continue;
            }

            for (int neigh = 0; neigh < n; neigh++) {
                if (adjMatrix[curr.node][neigh] > 0) {
                    if (curr.cost + adjMatrix[curr.node][neigh] < distance[neigh]) {    // better cost
                        distance[neigh] = curr.cost + adjMatrix[curr.node][neigh];
                        minHeap.offer(new Triplet(neigh, distance[neigh], curr.stops + 1));
                    } else if (curr.stops < currStops[neigh]) {
                        currStops[neigh] = curr.stops;
                        minHeap.offer(new Triplet(neigh, curr.cost + adjMatrix[curr.node][neigh], curr.stops + 1));
                    }
                }
            }
        }
        return distance[dest] == Integer.MAX_VALUE ? -1 : distance[dest];
    }

    class Triplet {
        int node, cost, stops;

        public Triplet(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public String toString() {
            return "{" +
                    "node=" + node +
                    ", cost=" + cost +
                    ", stops=" + stops +
                    '}';
        }
    }
}