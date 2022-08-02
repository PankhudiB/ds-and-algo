package graph;

import util.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Arrays;

class Runner {
    public static void main(String[] args) {
        NetworkDelayTime ndt = new NetworkDelayTime();
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(ndt.networkDelayTime(times, 4, 2));
    }
}

//Return the minimum time it takes for all the n nodes to receive the signal.
// we ll have to find how much

class NetworkDelayTime {

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