package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

    class SolutionUsingBFS {
        public int orangesRotting(int[][] grid) {
            Queue<int[]> queue = new LinkedList<int[]>();
            int rows = grid.length;
            int cols = grid[0].length;

            int freshOranges = 0;
            int[][] neighbours = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(grid[i][j] == 2) {
                        queue.offer(new int[]{i,j});
                    } else if (grid[i][j] == 1) {
                        freshOranges++;
                    }
                }
            }
            if (freshOranges == 0) return 0;
            int minute = -1;
            while(!queue.isEmpty()) {
                int currQueueSize = queue.size();

                for(int c=0; c< currQueueSize; c++) {

                    int[] curr = queue.remove();
                    int curr_x = curr[0];
                    int curr_y = curr[1];
                    for(int[] neighbour: neighbours) {
                        int x = curr_x + neighbour[0];
                        int y = curr_y + neighbour[1];

                        if(isSafe(x,y, rows, cols) && grid[x][y] == 1) {
                            grid[x][y] = 2;
                            queue.offer(new int[]{x,y});
                            freshOranges--;
                        }
                    }
                }
                minute++;
            }
            return freshOranges == 0 ? minute : -1;
        }

        private boolean isSafe(int x, int y, int rows, int cols) {
            if (x >= 0 && x < rows && y >= 0 && y < cols) return true;
            return false;
        }
    }
}