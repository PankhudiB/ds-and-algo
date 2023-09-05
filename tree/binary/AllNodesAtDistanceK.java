package tree.binary;

import util.ArrayUtil;

import java.util.*;

public class AllNodesAtDistanceK {
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

//                  5
//                /   \
//               4     8
//              / \   /
//             11    13
//            /  \
//            7   2

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;

        AllNodesAtDistanceK a = new AllNodesAtDistanceK();
        List<Integer> result = a.distanceK(node3, node5, 2);
        ArrayUtil.print(result);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    Map<Integer, TreeNode> childToParent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        childParent(root, null);

        Queue<TreeNode> que = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();

        que.add(target);


        while (k > 0 && !que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                visited.put(curr, true);

                TreeNode parent = childToParent.get(curr.val);
                if (curr.left != null && !visited.getOrDefault(curr.left, false)) que.add(curr.left);
                if (curr.right != null && !visited.getOrDefault(curr.right, false)) que.add(curr.right);
                if (parent != null && !visited.getOrDefault(parent, false)) que.add(parent);

            }
            k--;
        }

        List<Integer> result = new ArrayList<>();
        while (!que.isEmpty()) {
            TreeNode curr = que.poll();
            result.add(curr.val);
        }
        return result;
    }

    private void childParent(TreeNode curr, TreeNode parent) {
        if (curr == null) return;

        childToParent.put(curr.val, parent);
        childParent(curr.left, curr);
        childParent(curr.right, curr);
    }

    private void printQueue(Queue<TreeNode> que) {
        int size = que.size();

        while (size > 0) {
            TreeNode curr = que.poll();
            System.out.print(curr.val + " , ");
            size--;
            que.add(curr);
        }
        System.out.println();
    }

    private void printMap(Map<Integer, TreeNode> cp) {
        int size = cp.size();

        for (Map.Entry<Integer, TreeNode> entry : cp.entrySet()) {
            if (entry.getValue() != null)
                System.out.print(entry.getKey() + " : " + entry.getValue().val + " | ");
        }
        System.out.println();
    }
}

