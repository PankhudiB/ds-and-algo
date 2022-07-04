package graph;

import java.util.ArrayList;

public class Prims_MinCostToConnectAllPoints {
    /*
        Prims Algo ->
            always consider 2 Disjoint set -> and connect the 2 partition with min edge weight

        n - Number of nodes of the graph.
        mstCost - Cost to build the MST.
        edgesUsed - Number of edges included in the MST.
        inMST - Array to track which nodes are already part of the MST.
        minDist - Array to track the minimum edge weight to reach the ith node from any node that is already in the tree.


        1. add dummy entry -> minDist[0] = 0
        2. until edgesUsed --> n-1 + dummy entry = n
           2.1 pick node that is not in MST & has min edge weight
           2.2 edgesUsed++ , mstCost+=minDist[picked_node] , inMST[picked_node] = true
           2.3 update minDist of all from this particular node
        3. return mstCost
     */

    /*
        TC -> O(N^2)
        SC -> O(N)
     */

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int costOfMST = 0;
        int edgesUsed = 0;
        boolean[] inMST = new boolean[n];
        int[] minDist = new int[n];

        for (int i = 0; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        //dummy entry
        minDist[0] = 0;

        while (edgesUsed < n) {
            int minEdgeWeight = Integer.MAX_VALUE;
            int pickedNode = -1;
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && minDist[i] < minEdgeWeight) {
                    minEdgeWeight = minDist[i];
                    pickedNode = i;
                }
            }

            edgesUsed++;
            costOfMST += minEdgeWeight;
            System.out.println("->" + pickedNode);
            inMST[pickedNode] = true;

            for (int nextNode = 0; nextNode < n; nextNode++) {
                int weightFromPickedNode = Math.abs(points[pickedNode][0] - points[nextNode][0]) +
                        Math.abs(points[pickedNode][1] - points[nextNode][1]);

                if (!inMST[nextNode] && minDist[nextNode] > weightFromPickedNode) {
                    minDist[nextNode] = weightFromPickedNode;
                }
            }
        }
        return costOfMST;
    }
}
