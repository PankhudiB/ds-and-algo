package graph;

import java.util.ArrayList;

public class MinCostToConnectAllPoints {
    class UnionFind {
        private int[] rank;
        private int[] root;

        public UnionFind(int n){
            rank = new int[n];
            root = new int[n];

            for(int i=0;i<n;i++){
                rank[i] = 1;
                root[i] = i;
            }
        }

        public int find(int node) {
            if (root[node] != node) {
                root[node] = find(root[node]);
            }
            return root[node];
        }

        public boolean union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                // they already belong to same group -> and can form cycle
                return false;
            }
            if (rank[rootX] > rank[rootY]){
                root[rootY] = x;
            } else if (rank[rootY] > rank[rootX]){
                root[rootX] = rootY;
            } else {
                root[rootX] = rootY;
                rank[rootY]++;
            }
            return true; // union possible

        }
    }

    /*
        Solved using Kruskal -> 1. sort edges & 2. add the edge to mst if it doesnt form cycle
                                    -> to do 2. -> use Union Find DS
        TC ->  1. finding manhattan dist -> N^2 +
               2. sorting them -> N^2 * log(N^2) +
               3. for each edge -> doing union find --> N^2 * α(N)

               -> hence : N^2 * log(N^2)
     */
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            ArrayList<int[]> allEdges = new ArrayList<>();
            int costOfMST = 0;
            int edgesUsed = 0;
            for (int i=0;i<n; i++){
                for (int j=i+1; j<n ; j++){
                    int weight = Math.abs(points[i][0] - points[j][0]) +
                            Math.abs(points[i][1] - points[j][1]);

                    allEdges.add(new int[]{weight,i,j});
                }
            }

            allEdges.sort((a, b) -> Integer.compare(a[0], b[0]));


            UnionFind uf = new UnionFind(n);

            for(int i=0; i<allEdges.size() && edgesUsed< n-1; i++){
                if(uf.union(allEdges.get(i)[1],allEdges.get(i)[2])) {
                    costOfMST+=allEdges.get(i)[0];
                    edgesUsed++;
                }
            }
            return costOfMST;
        }
    }
}
