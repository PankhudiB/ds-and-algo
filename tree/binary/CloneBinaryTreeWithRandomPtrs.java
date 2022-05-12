package tree.binary;

import tree.Node;

import java.util.HashMap;

class NodeWithRandomPtr {
    int val;
    NodeWithRandomPtr left;
    NodeWithRandomPtr right;
    NodeWithRandomPtr random;

    NodeWithRandomPtr() {
    }

    NodeWithRandomPtr(int val) {
        this.val = val;
    }

    NodeWithRandomPtr(int val, NodeWithRandomPtr left, NodeWithRandomPtr right, NodeWithRandomPtr random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

class CloneBinaryTreeWithRandomPtrs {

    HashMap<NodeWithRandomPtr, NodeWithRandomPtr> oldToNew = new HashMap<>();

    public NodeWithRandomPtr copyRandomBinaryTree(NodeWithRandomPtr root) {
        return copy(root);
    }

    private NodeWithRandomPtr copy(NodeWithRandomPtr root) {
        if (root == null) return null;
        if (oldToNew.containsKey(root)) return oldToNew.get(root);
        NodeWithRandomPtr newNode = new NodeWithRandomPtr(root.val);
        oldToNew.put(root, newNode);

        newNode.left = copy(root.left);
        newNode.right = copy(root.right);
        newNode.random = copy(root.random);
        return newNode;
    }
}

