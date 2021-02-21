package tree.binary;

import tree.util.Util;

import java.util.LinkedList;
import java.util.Queue;


class NodeR {
    public int val;
    public NodeR left;
    public NodeR right;
    public NodeR next;

    public NodeR(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "";
    }
}

class PopulateRightPointers {
    public static void main(String[] args) {
        PopulateRightPointers r = new PopulateRightPointers();

        NodeR treeWithRightNeighbourConnected = r.connect(getCompleteBinaryTree());
        NodeR treeWithRightNeighbourConnected2 = r.connectWithoutUsingQueue(getCompleteBinaryTree());
        r.levelOrderUsingQueue(treeWithRightNeighbourConnected);
        r.levelOrderUsingQueue(treeWithRightNeighbourConnected2);
    }

    NodeR connect(NodeR head) {
        if (head == null) return null;
        Queue<NodeR> q = new LinkedList<>();
        q.add(head);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NodeR node = q.poll();
                if (i < size - 1) node.next = q.peek();

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return head;
    }

    NodeR connectWithoutUsingQueue(NodeR head) {
        NodeR leftmost = head;
        while (leftmost != null) {
            populateRightPtrs(leftmost);
            leftmost = leftmost.left;  // going each level from leftmost node
        }
        return head;
    }

    private void populateRightPtrs(NodeR node) {
        while (node != null) {
            // set it for left nodes -> which is obvious set it to right node of its own parent
            node.left.next = node.right;

            //for curr right.next -> leverage the link already created in previous step
            if (node.next != null) {
                node.right.next = node.next.left;
            }
            //keep moving in horizontal line -->
            node = node.next;
        }
    }

    private static NodeR getCompleteBinaryTree() {
        NodeR node1 = new NodeR(1);
        NodeR node2 = new NodeR(2);
        NodeR node3 = new NodeR(3);
        NodeR node4 = new NodeR(4);
        NodeR node5 = new NodeR(5);
        NodeR node6 = new NodeR(6);
        NodeR node7 = new NodeR(7);

//                  1
//                /   \
//               2     3
//              / \   / \
//             4   5  6   7
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        return node1;
    }

    void levelOrderUsingQueue(NodeR head) {
        Queue<NodeR> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            NodeR curr = queue.poll();
            System.out.println(curr.val + "-" + curr.next);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }
}

