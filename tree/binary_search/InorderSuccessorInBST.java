package tree.binary_search;

import tree.Node;

import java.util.Stack;

class InorderSuccessorInBST {

    public static void main(String[] args) {
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

//                  4
//                /   \
//               2     5
//                \
//                 3

        node4.left = node2;
        node4.right = node5;
        node2.right = node3;
        InorderSuccessorInBST utility = new InorderSuccessorInBST();
        System.out.println("inorderSuccessorInBST :" + utility.inorderSuccessorInBST(node4, node2));

        Node nodee1 = new Node(1);
        Node nodee2 = new Node(2);
        Node nodee3 = new Node(3);
        Node nodee4 = new Node(4);
        Node nodee5 = new Node(5);
        Node nodee6 = new Node(6);

//                  5
//                /   \
//               3     6
//              / \
//             2   4
//            /
//           1
        nodee5.left = nodee3;
        nodee5.right = nodee6;
        nodee3.left = nodee2;
        nodee3.right = nodee4;
        nodee2.left = nodee1;
        System.out.println("inorderSuccessorInBST :" + utility.inorderSuccessorInBST(nodee5, nodee2));
        System.out.println("inorderSuccessorInBST :" + utility.inorderSuccessorInBST(nodee5, nodee6));
        System.out.println("inorderSuccessorInBST :" + utility.inorderSuccessorInBST(nodee5, nodee4));
    }

    public Node inorderSuccessorInBST(Node head, Node p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }

        boolean foundP = false;
        if (head == null)
            return null;
        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (foundP) {
                return curr;
            }
            if (curr == p) foundP = true;
            curr = curr.right;
        }
        return null;
    }
}
