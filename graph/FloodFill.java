package graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    static class Coordiante {
        int x, y;
        int pixelClr;

        public Coordiante(int x, int y, int pixelClr) {
            this.x = x;
            this.y = y;
            this.pixelClr = pixelClr;
        }
    }

    public static void main(String[] args) {
        int image[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodfill(image, 1, 1, 2);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] floodfill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }

        Queue<Coordiante> queue = new LinkedList<>();
        queue.add(new Coordiante(sr, sc, newColor));
        int maxRows = image.length;
        int maxCols = image[0].length;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int x, y;
        while (!queue.isEmpty()) {
            Coordiante popped = queue.poll();
            image[popped.x][popped.y] = newColor;
            for (int i = 0; i < 4; i++) {
                x = popped.x + dx[i];
                y = popped.y + dy[i];
                Coordiante neighbor = new Coordiante(x, y, popped.pixelClr);
                if (isSafe(neighbor, maxRows, maxCols) && image[x][y] == oldColor) {
                    queue.add(neighbor);
                }
            }
        }
        return image;
    }

    static boolean isSafe(Coordiante coordiante, int maxRows, int maxCols) {
        return (coordiante.x >= 0 && coordiante.x < maxRows && coordiante.y >= 0 && coordiante.y < maxCols);
    }
}

