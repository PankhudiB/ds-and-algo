package queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class OpenLock {
    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock(deadends, "0202"));

        String[] deadends2 = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(openLock(deadends2, "8888"));

    }

    public static int openLock(String[] deadends, String target) {
        HashSet<String> deadendNodes = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String node = queue.poll();
                if (deadendNodes.contains(node)) {
                    size--;
                    level++;
                    continue;
                }
                if (node.equals(target)) return level;
                for (int i = 0; i < 4; i++) {
                    for (int rotate = -1; rotate <= 1; rotate += 2) {
                        int next = (node.charAt(i) - '0' + rotate + 10) % 10;
                        String neighbour = node.substring(0, i) + ("" + next) + node.substring(i + 1);
                        if (deadendNodes.contains(neighbour)) continue;
                        if (!visited.contains(neighbour)) {
                            queue.add(neighbour);
                            visited.add(neighbour);
                        }
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}

//Complexity: O(N^2 * A^N + D)
//        where, N is Number of dials (4 in our case)
//        A is number of alphabets (10 in our case -> 0 to 9)
//        D is the size of deadends.
//
//        There are 10 x 10 x 10 x 10 possible combinations => 10^4 => A^N
//        For each combination, we are looping 4 times (which is N) and in each iteration, there are substring operations ( which is O(N) * constant) => O(4N*constant) => O(4N) => O(NN) => O(N^2)
//        Total complexity => A^N * N^2, plus D to create the hashset => N^2 * A^N + D