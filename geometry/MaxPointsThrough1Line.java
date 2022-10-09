package geometry;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsThrough1Line {
    // Make straight line using every 2 points and then find
    // how many other points lie on this line created by above

    // for every line formed by  x1,y1 -- x2,y2
    // find x3,y3 that lies on the above line

    //  (y2-y1)       (y3-y1)
    // --------  ==   -------
    // (x2-x1)        (x3-x1)

    // since it involves division and might lead to floating point numbers difficult to compare
    // we can simplify by cross multiplying

    // (y2-y1) * (x3-x1) == (y3-y1) * (x2-x1)

    // Time complexity = O(N^3)

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 0 || n == 1 || n == 2) return n;

        int maxPointsOn1Line = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int total = 2; // i and j will obv be there on line through i and j
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        // (y2-y1) / (x2-x1) == (y3-y1) / (x3-x1)   can also be written as :
                        // (y2-y1) * (x3-x1) ==  (y3-y1) * (x2-x1)

                        int x1 = points[i][0];
                        int y1 = points[i][1];

                        int x2 = points[j][0];
                        int y2 = points[j][1];

                        int x3 = points[k][0];
                        int y3 = points[k][1];

                        if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)) total++;
                    }
                }
                maxPointsOn1Line = Math.max(maxPointsOn1Line, total);
            }
        }
        return maxPointsOn1Line;
    }
}

class MaxPointsThrough1LineSolution2 {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }

        Point(int[] xy) {
            x = xy[0];
            y = xy[1];
        }

    }

    // idea is
    // for each i --> maintain map of slope of line created from i to -> j and maintain map of slope to count
    // i --> j1
    // i --> j2
    // i --> j3
    // map[slope]count

    public int maxPoints(int[][] points_input) {
        int n = points_input.length;
        Point[] points = convertToPointsArray(points_input);

        int maxPointsOn1Line = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int max = 0;

            for (int j = i + 1; j < n; j++) {
                int deltaX = points[j].x - points[i].x;     // x2-x1
                int deltaY = points[j].y - points[i].y;     // y2-y1

                if (deltaX == 0 && deltaY == 0) {           // if x2-x1 && y2-y1 == 0 then its the same point
                    duplicate++;
                    continue;
                }

                // calculate gcd bcoz ->
                // if slope -> y2-y1 / x2-x1 ==> 2/6
                // you want to maintain slope like 1/3 instead of 2/6 so that its convinient to match with other lines slope
                int gcd = gcd(deltaX, deltaY);
                deltaX = deltaX / gcd;
                deltaY = deltaY / gcd;

                //use line representation as key

                String line = deltaX + "," + deltaY;
                Integer soFar = map.getOrDefault(line, 0);
                map.put(line, soFar + 1);
                max = Math.max(max, map.get(line));
            }
            maxPointsOn1Line = Math.max(maxPointsOn1Line, max + duplicate + 1);
        }
        return maxPointsOn1Line;
    }

    private Point[] convertToPointsArray(int[][] points_input) {
        int n = points_input.length;
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            points[i] = new Point(points_input[i]);
        }
        return points;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

