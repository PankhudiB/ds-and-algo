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


        1. set minDistToReachNode of all node to Infinite
        2. add dummy entry -> minDistToReachNode[0] = 0
        3. until edgesUsed --> n-1 + dummy entry = n
           3.1 pick node that is not in MST & has min edge weight
           3.2 edgesUsed++ , mstCost+=minDistToReachNode[picked_node] , inMST[picked_node] = true
           3.3 update minDistToReachNode of all from this particular node
        4. return mstCost
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
        int[] minDistToReachNode = new int[n];

        setAllDistToInfinite(n, minDistToReachNode);

        //dummy entry
        minDistToReachNode[0] = 0;

        while (edgesUsed < n) {
            int minEdgeWeight = Integer.MAX_VALUE;
            int pickedNode = -1;
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && minDistToReachNode[i] < minEdgeWeight) {
                    minEdgeWeight = minDistToReachNode[i];
                    pickedNode = i;
                }
            }

            edgesUsed++;
            costOfMST += minEdgeWeight;
            System.out.println("->" + pickedNode);
            inMST[pickedNode] = true;

            //update dist from pickedNode to others
            for (int nextNode = 0; nextNode < n; nextNode++) {
                int distFromPickedNode = Math.abs(points[pickedNode][0] - points[nextNode][0]) +
                        Math.abs(points[pickedNode][1] - points[nextNode][1]);

                if (!inMST[nextNode] && minDistToReachNode[nextNode] > distFromPickedNode) {
                    minDistToReachNode[nextNode] = distFromPickedNode;
                }
            }
        }
        return costOfMST;
    }

    private void setAllDistToInfinite(int n, int[] minDistToReachNode) {
        for (int i = 0; i < n; i++) {
            minDistToReachNode[i] = Integer.MAX_VALUE;
        }
    }
}
