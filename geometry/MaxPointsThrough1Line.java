package geometry;

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
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int total = 2; // i and j will obv be there on line through i and j
                for(int k=0; k<n; k++){
                    if(k != i && k != j) {
                        // (y2-y1) / (x2-x1) == (y3-y1) / (x3-x1)   can also be written as :
                        // (y2-y1) * (x3-x1) ==  (y3-y1) * (x2-x1)

                        int x1 = points[i][0];
                        int y1 = points[i][1];

                        int x2 = points[j][0];
                        int y2 = points[j][1];

                        int x3 = points[k][0];
                        int y3 = points[k][1];

                        if ((y2-y1) * (x3-x1) == (y3-y1) * (x2-x1)) total++;
                    }
                }
                maxPointsOn1Line = Math.max(maxPointsOn1Line,total);
            }
        }
        return maxPointsOn1Line;
    }
}
