package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Chopstick {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter pr = new PrintWriter(System.out);
        int length = sc.nextInt();
        long maxDiffAllowed = sc.nextLong();
        long[] chopsticks = new long[length];
        for (int i = 0; i < length; i++) {
            chopsticks[i] = sc.nextLong();
        }
        int count = 0;
        Arrays.sort(chopsticks);
        int size = chopsticks.length;
        for (int i = 1; i < size; i++) {
            long diff = chopsticks[i] - chopsticks[i - 1];
            if (diff <= maxDiffAllowed) {
                count++;
                i++;
            }
        }
        pr.println(count);
        pr.flush();
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
