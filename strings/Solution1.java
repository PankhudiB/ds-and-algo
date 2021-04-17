package strings;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Solution1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tc = sc.nextInt();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int t = 1; t <= tc; t++) {
//            System.out.println("Testcase " + t);
            String ans = "A";
            int noOfBlocks = sc.nextInt();
//            System.out.println("noOfBlocks " + noOfBlocks);
            int[] blockSizes = new int[noOfBlocks + 1];
            blockSizes[0] = 1;
            for (int i = 1; i < blockSizes.length; i++) {
                blockSizes[i] = sc.nextInt();
            }
            printArr(blockSizes);
            // blocksizes
            ArrayList<String> output = new ArrayList<>(noOfBlocks);
            output.add("A");
            if (noOfBlocks == 1) {
                ans += getIncremental('A', blockSizes[1]);
            } else {
                for (int i = 1; i < blockSizes.length; i++) {
                    int parity = i + 1;
//                System.out.println("eo : " + parity);
                    int x = i;
                    int y = i + 1;
                    if ((parity) % 2 == 0) { // even
                        char prevLast = output.get(i - 1).charAt(output.get(i - 1).length() - 1);
//                    System.out.println(prevLast);
                        if (blockSizes[x] > blockSizes[y]) {
                            output.add(getIncremental(prevLast, blockSizes[x]));
                            ans += getIncremental(prevLast, blockSizes[x]);
                        } else {
                            String next = getIncremental(prevLast, blockSizes[x]);
//                        System.out.println("alpha.charAt(blockSizes[y]" + alpha.charAt(blockSizes[y]) + " my last : " + alpha.charAt(blockSizes[y] + 1));
//                        System.out.println(next.substring(0, next.length() - 1) + alpha.charAt(blockSizes[y]));
                            output.add(next.substring(0, next.length() - 1) + "" + alpha.charAt(blockSizes[y]));
                            ans += next.substring(0, next.length() - 1) + "" + alpha.charAt(blockSizes[y]);
                        }
                    } else {    //odd
                        output.add(getDecremental(blockSizes[x]));
                        ans += getDecremental(blockSizes[x]);
                    }
                }
            }
//            System.out.println(output);
            System.out.println("Case #" + t + ": " + ans);
        }
    }

    private static String getIncremental(int from, int n) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alpha.substring(('A' - from) + 1, n + 1);
    }

    private static String getDecremental(int till, int n) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String output = "";
        for (int i = till; i > n; i--) {
            output += alpha.charAt(i);
        }
//        System.out.println("getDecremental : " + output);
        return output;
    }

    private static String getDecremental(int till) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String output = "";
//        System.out.println("till " + till);
        for (int i = till - 1; i >= 0; i--) {
            output += alpha.charAt(i);
        }
//        System.out.println("getDecremental : " + output);
        return output;
    }


    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        boolean ready() throws IOException {
            return br.ready();
        }


        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }


        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public double[] nextDoubleArray(int n) throws IOException {
            double[] ans = new double[n];
            for (int i = 0; i < n; i++)
                ans[i] = nextDouble();
            return ans;
        }

        public short nextShort() throws IOException {
            return Short.parseShort(next());
        }

    }

    private static void printArr(int[] path) {
        for (int i = 0; i < path.length; i++) {
//            System.out.print(path[i] + " ");
        }
//        System.out.println();
    }

}