package tree.binary;

import tree.Node;
import tree.util.Util;
import util.Triplet;

import java.util.*;

class VerticalTraversal {
    List<Triplet<Integer, Integer, Integer>> nodeList;

    public static void main(String[] args) {
        VerticalTraversal l = new VerticalTraversal();

        System.out.println(l.verticalTraversal(Util.getBigBinaryTreeVariant1()));
        System.out.println("---");

        System.out.println(l.verticalTraversal(Util.getCompleteBinaryTree()));
        System.out.println("---");
    }

    public List<Integer> verticalTraversal(Node root) {
        List<Integer> output = new ArrayList();
        nodeList = new ArrayList<>();
        if (root == null) return output;

        BFS(root);

        //sort by col then row then node value
        Collections.sort(this.nodeList, new Comparator<Triplet<Integer, Integer, Integer>>() {
            @Override
            public int compare(Triplet<Integer, Integer, Integer> o1, Triplet<Integer, Integer, Integer> o2) {
                if (o1.first.equals(o2.first)) {        //compare col
                    if (o1.second.equals(o2.second)) {  //compare row
                        return o1.third - o2.third;     // if same col and same row -> ascending order of val
                    } else {
                        return o1.second - o2.second;   //if same col -> row by row top to bottom
                    }
                } else {
                    return o1.first - o2.first;        // ascending order of col
                }
            }
        });

        for (Triplet<Integer, Integer, Integer> triplet : this.nodeList) {
            output.add(triplet.third);
        }
        return output;
    }

    private void BFS(Node root) {
        Queue<Triplet<Integer, Integer, Node>> queue = new LinkedList<>();
        int row = 0, col = 0;
        queue.add(new Triplet(col, row, root));
        while (!queue.isEmpty()) {
            Triplet<Integer, Integer, Node> triplet = queue.poll();
            col = triplet.first;
            row = triplet.second;
            root = triplet.third;

            if (root != null) {
                nodeList.add(new Triplet(col, row, root.val));
                queue.add(new Triplet(col - 1, row + 1, root.left));
                queue.add(new Triplet(col + 1, row + 1, root.right));
            }
        }
    }
}

