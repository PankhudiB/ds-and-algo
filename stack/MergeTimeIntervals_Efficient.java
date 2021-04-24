package stack;

import java.util.Arrays;
import java.util.Comparator;

public class MergeTimeIntervals_Efficient {

    public static void main(String[] args) {
        Interval arr[] = new Interval[4];
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        arr[0] = new Interval(6, 8);
        mergeIntervals(arr);
        System.out.println("--------");
        Interval arr2[] = new Interval[4];
        arr2[1] = new Interval(1, 3);
        arr2[2] = new Interval(2, 4);
        arr2[3] = new Interval(5, 7);
        arr2[0] = new Interval(6, 8);
        mergeIntervals(arr2);
    }

    private static void mergeIntervals(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        int curr = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[curr].end >= intervals[i].start) {
                intervals[curr].end = Math.max(intervals[curr].end, intervals[i].end);
                intervals[curr].start = Math.min(intervals[curr].start, intervals[i].start);
            } else {
                curr++;
                intervals[curr] = intervals[i];
            }
        }
        for (int i = 0; i <= curr; i++) {
            System.out.println(intervals[i]);
        }
    }
}
