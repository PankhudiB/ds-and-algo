package stack;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, HashMap<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clone = new Node(node.val, new ArrayList());
        visited.put(node, clone);


        for (Node neigh : node.neighbors) {
            clone.neighbors.add(dfs(neigh, visited));
        }

        return clone;
    }

    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

    class SolvedAgainUsingDFS {
        Map<Node, Node> visited = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) return null;

            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            Node newNode = new Node(node.val, new ArrayList<>());
            visited.put(node, newNode);

            for (Node neigh : node.neighbors) {
                newNode.neighbors.add(cloneGraph(neigh));
            }

            return newNode;
        }
    }

    class SolvedAgainUsingBFS {
        Map<Node, Node> visited = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Queue<Node> queue = new LinkedList<>();

            queue.add(node);
            visited.put(node, new Node(node.val));

            while (!queue.isEmpty()) {
                Node currNode = queue.remove();

                for (Node neigh : currNode.neighbors) {
                    if (!visited.containsKey(neigh)) {
                        visited.put(neigh, new Node(neigh.val));
                        queue.add(neigh);
                    }
                    visited.get(currNode).neighbors.add(visited.get(neigh));
                }
            }

            return visited.get(node);
        }
    }
}
