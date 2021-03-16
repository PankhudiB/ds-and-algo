package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CleanTables {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter pr = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int noOfTables = sc.nextInt();
            int noOfOrders = sc.nextInt();
            int[] orders = new int[noOfOrders];
            for (int i = 0; i < noOfOrders; i++) {
                orders[i] = sc.nextInt();
            }
            pr.println(minTimesToCleanTable(orders, noOfTables));
            pr.flush();
        }
    }

    private static int minTimesToCleanTable(int[] orders, int noOfTables) {
        Deque<Integer> lruForOrders = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        int noOfCleanings = 0;
        for (Integer order : orders) {
            if (!hashSet.contains(order)) {
                noOfCleanings++;
                if (hashSet.size() == noOfTables) {
                    Integer leastRecentlyOrdered = lruForOrders.removeLast();
                    hashSet.remove(leastRecentlyOrdered);
                }
            } else {
                lruForOrders.remove(order);
            }
            lruForOrders.push(order);
            hashSet.add(order);
        }
        return noOfCleanings;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
