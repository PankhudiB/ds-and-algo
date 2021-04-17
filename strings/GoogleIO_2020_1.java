package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoogleIO_2020_1 {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter pr = new PrintWriter(System.out);
        int t = sc.nextInt();

        while (t-- > 0) {
            int ICount = 0;
            int iCount = 0;
            int IOCount = 0;

            String input = sc.next();

            for (Character c : input.toCharArray()) {
                if (c == 'I') ICount++;
                if (c == 'i') iCount++;
                if (c == 'O') {
                    if (ICount > 0) {
                        ICount--;
                        IOCount++;
                    } else {
                        iCount--;
                    }
                }
                if (c == 'o') {
                    if (iCount > 0) {
                        iCount--;
                    } else {
                        ICount--;
                    }
                }
            }

            pr.println(IOCount);
            pr.flush();
        }
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
