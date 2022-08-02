package graph;

import util.Tuple;

import java.util.*;

class Runner {
    public static void main(String[] args) {
        NetworkDelayTimeDFS ndt = new NetworkDelayTimeDFS();
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(ndt.networkDelayTime(times, 4, 2));
    }
}

//Return the minimum time it takes for all the n nodes to receive the signal.
// we ll have to find min dist from source for all points


// DFS ->
class NetworkDelayTimeDFS {

    Map<Integer, List<Tuple<Integer, Integer>>> adj = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {

        for (int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int timeTaken = time[2];

            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(new Tuple(dest, timeTaken));
        }

        for (int node : adj.keySet()) {
            Collections.sort(adj.get(node), (a, b) -> a.getValue() - b.getValue());
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        DFS(signalReceivedAt, k, 0);

        signalReceivedAt[0] = 0;

        int minTimeToReachAll = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            if (signalReceivedAt[i] > minTimeToReachAll)
                minTimeToReachAll = Math.max(signalReceivedAt[i], minTimeToReachAll);
        }

        return minTimeToReachAll == Integer.MAX_VALUE ? -1 : minTimeToReachAll;
    }

    private void DFS(int[] signalReceivedAt, int currNode, int currTime) {
        if (currTime >= signalReceivedAt[currNode]) {
            return;
        }

        signalReceivedAt[currNode] = currTime;

        if (!adj.containsKey(currNode)) return;


        for (Tuple<Integer, Integer> pair : adj.get(currNode)) {
            int neighborNode = pair.getKey();
            int travelTime = pair.getValue();

            DFS(signalReceivedAt, neighborNode, currTime + travelTime);
        }
    }

}

//BFS ->


//Dijkstra's
// BFS + Priority queue
class NetworkDelayTimeDijkstra {

    Map<Integer, List<Tuple<Integer, Integer>>> adj = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {

        for (int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int timeTaken = time[2];

            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(new Tuple(dest, timeTaken));
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        BFS(signalReceivedAt, k);

        int minTimeToReachAll = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            minTimeToReachAll = Math.max(minTimeToReachAll, signalReceivedAt[i]);
        }

        return minTimeToReachAll == Integer.MAX_VALUE ? -1 : minTimeToReachAll;
    }

    private void BFS(int[] signalReceivedAt, int startNode) {
        Queue<Tuple<Integer, Integer>> pq = new PriorityQueue<Tuple<Integer, Integer>>(Comparator.comparing(Tuple::getValue));
        pq.add(new Tuple(startNode, 0));
        signalReceivedAt[startNode] = 0;

        while (!pq.isEmpty()) {
            Tuple<Integer, Integer> topPair = pq.remove();
            int currNode = topPair.getKey();
            int currTime = topPair.getValue();

            if (currTime > signalReceivedAt[currNode]) continue;

            if (!adj.containsKey(currNode)) continue;

            for (Tuple<Integer, Integer> pair : adj.get(currNode)) {
                int neighNode = pair.getKey();
                int neighTime = pair.getValue();
                int arrivalTime = signalReceivedAt[currNode] + neighTime;

                if (signalReceivedAt[neighNode] > arrivalTime) {
                    signalReceivedAt[neighNode] = arrivalTime;
                    pq.add(new Tuple(neighNode, signalReceivedAt[neighNode]));
                }
            }
        }
    }
}