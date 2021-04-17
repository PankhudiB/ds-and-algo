package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int i = 1;
        while (i <= t) {
            int result = 1;
            int curr = 1;
            int noOfPets = sc.nextInt();
            List<Integer> pets = new ArrayList(noOfPets);
            while (noOfPets-- > 0) {
                pets.add(sc.nextInt());
            }
            Collections.sort(pets);

            for (int j = 1; j < pets.size(); j++) {
                if (pets.get(j) - pets.get(j - 1) != 0) {
                    curr++;
                }
                result += curr;
            }
            System.out.println("Case #" + i + ": " + result);
            i++;
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
