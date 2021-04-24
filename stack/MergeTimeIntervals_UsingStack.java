package stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class MergeTimeIntervals_UsingStack {

    public static void main(String[] args) {
        MergeTimeIntervals_UsingStack c = new MergeTimeIntervals_UsingStack();
        Interval arr[] = new Interval[4];
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        arr[0] = new Interval(6, 8);
        mergeIntervals(arr);

        Interval arr2[] = new Interval[4];
        arr2[1] = new Interval(1, 3);
        arr2[2] = new Interval(2, 4);
        arr2[3] = new Interval(5, 7);
        arr2[0] = new Interval(6, 8);
        mergeIntervals(arr2);
    }

    private static void mergeIntervals(Interval[] intervals) {
        Stack<Interval> stack = new Stack<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        stack.push(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            Interval top = stack.peek();
            if (top.end < intervals[i].start)
                stack.push(intervals[i]);
            else if (top.end < intervals[i].end) {
                top.end = intervals[i].end;
                stack.pop();
                stack.push(top);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
