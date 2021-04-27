package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
        reverse();
        System.out.println(queue);
    }

    private static void reverse() {
        if (queue.size() > 0) {
            Integer elem = queue.peek();
            queue.remove();
            reverse();
            queue.add(elem);
        }
    }
}
