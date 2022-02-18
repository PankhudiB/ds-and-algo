package heap;

import java.util.Collections;
import java.util.PriorityQueue;

class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println("Answer " + lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println("Answer " + lastStoneWeight(new int[]{2}));
        System.out.println("Answer " + lastStoneWeight(new int[]{9, 3, 2, 10}));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            heap.add(stone);
        }
        int smash_result = 0;
        if (heap.size() == 1) return heap.remove();
        while (heap.size() > 1) {
            int first = heap.remove();
            int second;
            if (heap.size() > 0) {
                second = heap.remove();
            } else {
                break;
            }
            if (first == second) {
                heap.add(0);
            }
            else {
                smash_result = Math.abs(first - second);
                heap.add(smash_result);
            }
        }
        return heap.remove();
    }
}

