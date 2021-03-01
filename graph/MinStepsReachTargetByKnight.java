package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinStepsReachTargetByKnight {
    static class Cell {
        int x, y;
        int distance;

        public Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
// 1 - BASED INDEX ----- 1 - BASED INDEX ----- 1 - BASED INDEX ----- 1 - BASED INDEX ----- 1 - BASED INDEX ----- 1 - BASED INDEX
        MinStepsReachTargetByKnight k = new MinStepsReachTargetByKnight();
        int sizeOfBoard = 8;
        Position knightPos = new Position(4, 5);
        Position targetPos = new Position(1, 1);
        System.out.println("min steps to reach target by knight : " + k.minStepToReach(knightPos, targetPos, sizeOfBoard));

        int sizeOfBoard2 = 30;
        Position knightPos2 = new Position(1, 1);
        Position targetPos2 = new Position(30, 30);
        System.out.println("min steps to reach target by knight : " + k.minStepToReach(knightPos2, targetPos2, sizeOfBoard2));
    }

    private int minStepToReach(Position knightPos, Position targetPos, int sizeOfBoard) {
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(knightPos.x, knightPos.y, 0));

        boolean[][] visited = new boolean[sizeOfBoard+1][sizeOfBoard+1];
        visited[knightPos.x][knightPos.y] = true;

        Cell c;
        int x, y;
        while (!queue.isEmpty()) {
            Cell popped = queue.poll();
            if (reachedDestination(popped, targetPos)) return popped.distance;

            for (int i = 0; i < 8; i++) {
                x = popped.x + dx[i];
                y = popped.y + dy[i];
                c = new Cell(x, y, popped.distance + 1);
                if (this.isSafe(c, sizeOfBoard) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(c);
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private static boolean reachedDestination(Cell cell, Position target) {
        return cell.x == target.x && cell.y == target.y;
    }

    private boolean isSafe(Cell cell, int sizeOfBoard) {
        return (cell.x >= 1 && cell.x <= sizeOfBoard && cell.y >= 1 && cell.y <= sizeOfBoard);
    }
}

