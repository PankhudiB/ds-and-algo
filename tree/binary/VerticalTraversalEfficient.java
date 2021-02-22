package tree.binary;

import tree.Node;
import tree.util.Util;
import util.Tuple;

import java.util.*;

class VerticalTraversalEfficient {
    Map<Integer, ArrayList<Tuple<Integer, Integer>>> columnTable;
    int minColumn = 0, maxColumn = 0;

    public static void main(String[] args) {
        VerticalTraversalEfficient l = new VerticalTraversalEfficient();

        System.out.println(l.verticalTraversal(Util.getBigBinaryTreeVariant1()));
        System.out.println("---");

        System.out.println(l.verticalTraversal(Util.getCompleteBinaryTree()));
        System.out.println("---");
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        columnTable = new HashMap();
        List<List<Integer>> output = new ArrayList();
        if (root == null) return output;

        BFS(root);

        //for each col ---> sort them
        for (int i = minColumn; i < maxColumn + 1; i++) {
            Collections.sort(this.columnTable.get(i), new Comparator<Tuple<Integer, Integer>>() {
                @Override
                public int compare(Tuple<Integer, Integer> t1, Tuple<Integer, Integer> t2) {
                    if (t1.first.equals(t2.first)) {
                        return t1.second - t2.second;
                    } else {
                        return t1.first - t2.first;
                    }
                }
            });

            List<Integer> perColumnData = new ArrayList<>();
            for (Tuple<Integer, Integer> rowAndNodeVal : columnTable.get(i)) {
                perColumnData.add(rowAndNodeVal.second);
            }
            output.add(perColumnData);
        }
        return output;
    }

    private void BFS(Node root) {
        Queue<Tuple<Node, Tuple<Integer, Integer>>> queue = new LinkedList<>();
        int row = 0, col = 0;
        queue.add(new Tuple(root, new Tuple(row, col)));
        while (!queue.isEmpty()) {
            Tuple<Node, Tuple<Integer, Integer>> curr = queue.poll();
            root = curr.first;
            row = curr.second.first;
            col = curr.second.second;

            if (root != null) {
                if (!columnTable.containsKey(col)) {
                    columnTable.put(col, new ArrayList<Tuple<Integer, Integer>>());
                }
                columnTable.get(col).add(new Tuple<>(row, root.val));
                minColumn = Math.min(minColumn, col);
                maxColumn = Math.min(maxColumn, col);
                queue.add(new Tuple(root.left, new Tuple(row + 1, col - 1)));
                queue.add(new Tuple(root.right, new Tuple(row + 1, col + 1)));
            }
        }
    }
}

