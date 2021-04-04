package graph;

import java.util.*;

public class GraphColoringEfficient_WelshPowell {
    int noOfVertices;

    class Vertex {
        int val;
        ArrayList<Vertex> neighbors;

        @Override
        public String toString() {
            String nh = "";
            for (int i = 0; i < neighbors.size(); i++) {
                nh += neighbors.get(i).val + " ";
            }
            return "V{" +
                    "val=" + val +
                    ", nh=" + nh + '}';

        }

        public Vertex(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Vertex(int val, ArrayList<Vertex> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    class VertexComparator implements Comparator<Vertex> {
        @Override
        public int compare(Vertex v1, Vertex v2) {
            return Integer.compare(v2.neighbors.size(), v1.neighbors.size());
        }
    }

    ArrayList<Vertex> vertices;

    public GraphColoringEfficient_WelshPowell(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        vertices = new ArrayList<>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) {
            vertices.add(new Vertex(i));
        }
    }

    public static void main(String[] args) {
        GraphColoringEfficient_WelshPowell graph2 = new GraphColoringEfficient_WelshPowell(5);
//              /  2  \
//        0 - 1    |    4
//              \  3  /

        graph2.addEdges(0, 1);
        graph2.addEdges(1, 2);
        graph2.addEdges(1, 3);
        graph2.addEdges(2, 3);
        graph2.addEdges(2, 4);
        graph2.addEdges(3, 4);

        Map<Vertex, Integer> colorMap = graph2.paintEfficient();
        System.out.println(colorMap);
        System.out.println("Distinct colors used : " + colorMap.values().stream().distinct().count());
    }

    private Map<Vertex, Integer> paintEfficient() {
        Map<Vertex, Integer> result = new HashMap<>();
        Map<Vertex, Boolean> visited = new HashMap<>();
        boolean[] available = new boolean[noOfVertices];
        Queue<Vertex> queue = new LinkedList<>();
        for (int i = 0; i < noOfVertices; i++) {
            result.put(vertices.get(i), -1);
            available[i] = true;
            visited.put(vertices.get(i), false);
        }

        Collections.sort(vertices, new VertexComparator());
        Vertex src = vertices.get(0);

        result.put(src, 0);
        queue.add(src);

        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            visited.put(curr, true);

            Iterator<Vertex> itr = curr.neighbors.iterator();
            while (itr.hasNext()) {
                Vertex neighbour = itr.next();

                if (!visited.get(neighbour)) {
                    queue.add(neighbour);
                }
                if (result.get(neighbour) != -1) {
                    available[result.get(neighbour)] = false;
                }
            }
            int firstAvailableClr = findFirstAvailableColor(available);
            result.put(curr, firstAvailableClr);
            Arrays.fill(available, true);
        }
        return result;
    }

    private int findFirstAvailableColor(boolean[] available) {
        int firstAvailableClr;
        for (firstAvailableClr = 0; firstAvailableClr < noOfVertices; firstAvailableClr++) {
            if (available[firstAvailableClr]) break;
        }
        return firstAvailableClr;
    }

    private void addEdges(int src, int dest) {
        vertices.get(src).neighbors.add(vertices.get(dest));
        vertices.get(dest).neighbors.add(vertices.get(src));
    }
}

