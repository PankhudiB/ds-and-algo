package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JourneyToMoon {
    private int noOfAstors;
    private ArrayList<Integer> adj[];
    int noOfAstrosOfSameCountry = 0;

    public JourneyToMoon(int noOfAstors) {
        this.noOfAstors = noOfAstors;
        adj = new ArrayList[noOfAstors];
        for (int i = 0; i < noOfAstors; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int noOfAstors = fastReader.nextInt();
        JourneyToMoon g = new JourneyToMoon(noOfAstors);
        int pairs = fastReader.nextInt();
        for (int i = 0; i < pairs; i++) {
            int u = fastReader.nextInt();
            int v = fastReader.nextInt();
            g.addEdge(u, v);
        }
        System.out.println(g.findMaxPairsPossible());
    }

    private void addEdge(int u, int v) {
        this.adj[u].add(v);
    }

    private int findMaxPairsPossible() {
        int totalPossible = (noOfAstors * (noOfAstors - 1)) / 2;
        boolean[] visited = new boolean[noOfAstors];
        for (int i = 0; i < noOfAstors; i++) {
            noOfAstrosOfSameCountry = 0;
            if (!visited[i]) DFS(i, visited);
            totalPossible -= (noOfAstrosOfSameCountry * (noOfAstrosOfSameCountry - 1)) / 2;
        }
        return totalPossible;
    }

    private void DFS(int u, boolean[] visited) {
        visited[u] = true;
        noOfAstrosOfSameCountry++;
        for (int v : adj[u]) {
            if (!visited[v])
                DFS(v, visited);
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
    }
}
