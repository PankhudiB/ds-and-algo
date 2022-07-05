package stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    class SolvedAgain {
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
}
