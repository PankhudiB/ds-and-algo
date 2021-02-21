package tree.binary;

import tree.Node;
import tree.util.Util;

import java.util.*;

class LowestCommonAncestor {
    private Node lca;

    LowestCommonAncestor() {
        this.lca = null;
    }

    public static void main(String[] args) {
        LowestCommonAncestor l = new LowestCommonAncestor();

        Node variant1Head = Util.getBigBinaryTreeVariant1();
        Node node3 = variant1Head.right;
        Node node4 = variant1Head.right.left;
        Node node8 = variant1Head.right.right.right;


        System.out.println("Lowest common ancestor of 4 and 8 is :" + l.findLowestCommonAncestor(variant1Head, node4, node8));
        System.out.println("Lowest common ancestor is 3 nad 4 is :" + l.findLowestCommonAncestor(variant1Head, node4, node3));

        System.out.println("Lowest common ancestor of 4 and 8 is :" + l.iterativeWithParentPointers(variant1Head, node4, node8));
        System.out.println("Lowest common ancestor is 3 nad 4 is :" + l.iterativeWithParentPointers(variant1Head, node4, node3));
    }

    public Node findLowestCommonAncestor(Node head, Node p, Node q) {
        recurse(head, p, q);
        return this.lca;
    }

    private boolean recurse(Node curr, Node p, Node q) {
        if (curr == null) return false;
        int left = recurse(curr.left, p, q) ? 1 : 0;
        int right = recurse(curr.right, p, q) ? 1 : 0;
        int mid = (curr == p || curr == q) ? 1 : 0;
        if (mid + left + right >= 2) this.lca = curr;
        return (mid + left + right > 0);
    }

    private Node iterativeWithParentPointers(Node head, Node p, Node q) {
        Stack<Node> stack = new Stack<>();
        Map<Node, Node> parents = new HashMap<>();
        parents.put(head, null);
        stack.push(head);

        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            Node curr = stack.pop();

            if (curr.left != null) {
                parents.put(curr.left, curr);
                stack.push(curr.left);
            }
            if (curr.right != null) {
                parents.put(curr.right, curr);
                stack.push(curr.right);
            }
        }
        Set<Node> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }

        while (!ancestors.contains(q)) {
            q = parents.get(q);
        }
        return q;

    }
}

