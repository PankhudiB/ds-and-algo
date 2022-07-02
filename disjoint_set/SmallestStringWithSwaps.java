package disjoint_set;

import java.util.*;

public class SmallestStringWithSwaps {
    /*
        TC -> O((E+V)⋅α(V)+VlogV)
        
    */


    public static void main(String[] args) {
        List<List<Integer>> pairs = new ArrayList<>();
        ArrayList<Integer> pair1 = new ArrayList<>();
        pair1.add(0);
        pair1.add(3);
        pairs.add(pair1);

        ArrayList<Integer> pair2 = new ArrayList<>();
        pair2.add(1);
        pair2.add(2);
        pairs.add(pair2);

        System.out.println(smallestStringWithSwaps("dcab", pairs));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());

        // Iterate over the edges
        for (List<Integer> edge : pairs) {
            int source = edge.get(0);
            int destination = edge.get(1);

            // Perform the union of end points
            uf.union(source, destination);
        }

        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        // Group the vertices that are in the same component
        for (int vertex = 0; vertex < s.length(); vertex++) {
            int root = uf.find(vertex);
            // Add the vertices corresponding to the component root
            rootToComponent.putIfAbsent(root, new ArrayList<>());
            rootToComponent.get(root).add(vertex);
        }

        // String to store the answer
        char[] smallestString = new char[s.length()];


        System.out.println(rootToComponent);


        // Iterate over each component
        for (List<Integer> indices : rootToComponent.values()) {
            // Sort the characters in the group
            List<Character> characters = new ArrayList<>();
            for (int index : indices) {
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);

            // Store the sorted characters

            for (int index = 0; index < indices.size(); index++) {
                smallestString[indices.get(index)] = characters.get(index);
            }
        }

        return new String(smallestString);
    }

    static class UnionFind {
        private int[] root;
        private int[] rank;

        // Initialize the array root and rank
        // Each vertex is representative of itself with rank 1
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        // Get the root of a vertex
        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        // Perform the union of two components
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] >= rank[rootY]) {
                    root[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                } else {
                    root[rootX] = rootY;
                    rank[rootY] += rank[rootX];
                }
            }
        }
    }
}

