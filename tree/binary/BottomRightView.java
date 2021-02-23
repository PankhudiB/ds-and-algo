package tree.binary;

import tree.Node;
import tree.Traversal;
import tree.util.Util;

import java.util.*;


class Pair<First extends Comparable<First>, Second extends Comparable<Second>> {
    public final First first;
    public final Second second;

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    public Pair(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public int compareTo(Pair<First, Second> t) {
        int retVal = this.first.compareTo(t.first);
        if (retVal != 0) return retVal;
        return this.second.compareTo(t.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

class BottomRightView {
    Map<Pair<Integer, Integer>, Integer> bottomRightView;

    public static void main(String[] args) {
        BottomRightView l = new BottomRightView();

        System.out.println("Bottom Right view : ");
        System.out.println(l.bottomRightView(Util.getBinaryTreeVariant3()));
        System.out.println("---");

        System.out.println("Bottom Right view : ");
        System.out.println(l.bottomRightView(Util.getBigBinaryTreeVariant1()));
        System.out.println("---");
    }

    public ArrayList<Integer> bottomRightView(Node root) {
        bottomRightView = new HashMap<>();
        Traversal traversal = new Traversal();
        int depth = traversal.depth(root);
        recurse(root, 0, depth);
        System.out.println(bottomRightView);
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(bottomRightView.values());
        return list;
    }

    private void recurse(Node node, int horizontalDistance, int verticalDistance) {
        if (node == null) return;
        if (bottomRightView.containsKey(new Pair(horizontalDistance - 1, verticalDistance + 1))) {
            bottomRightView.remove(new Pair(horizontalDistance - 1, verticalDistance + 1));
        }
        bottomRightView.put(new Pair(horizontalDistance, verticalDistance), node.val);
        if (node.left != null) recurse(node.left, horizontalDistance - 1, verticalDistance - 1);
        if (node.right != null) recurse(node.right, horizontalDistance + 1, verticalDistance - 1);
    }
}

