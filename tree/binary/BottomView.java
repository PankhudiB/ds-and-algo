package tree.binary;

import tree.Node;
import tree.util.Util;

import java.util.*;
import java.util.Map;

class BottomView {
    Map<Integer, Integer> bottomView;

    public static void main(String[] args) {
        BottomView l = new BottomView();

        System.out.println("Bottom view : ");
        System.out.println(l.bottomView(Util.getBinaryTreeVariant1()));
        System.out.println("---");

        System.out.println(l.bottomView(Util.getCompleteBinaryTree()));
        System.out.println("---");
    }

    public ArrayList<Integer> bottomView(Node root) {
        bottomView = new TreeMap<>();
        horizontalDistance(root, 0);
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(bottomView.values());
        return list;
    }

    private void horizontalDistance(Node node, int horizontalDistance) {
        if (node == null) return;
        bottomView.put(horizontalDistance, node.val);
        if (node.left != null) horizontalDistance(node.left, horizontalDistance - 1);
        if (node.right != null) horizontalDistance(node.right, horizontalDistance + 1);
    }

}

