package linked_list.singly;

import java.util.HashMap;

class NodeWithRandomPointers {
    int val;
    NodeWithRandomPointers next;
    NodeWithRandomPointers random;

    public NodeWithRandomPointers(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}

class CopyListWithRandomPointers {
    HashMap<NodeWithRandomPointers, NodeWithRandomPointers> oldToNew = new HashMap<>();

    public NodeWithRandomPointers copyRandomList(NodeWithRandomPointers head) {
        return helper(head);
    }

    private NodeWithRandomPointers helper(NodeWithRandomPointers node) {
        if (node == null) return null;
        if (oldToNew.containsKey(node)) return oldToNew.get(node);

        NodeWithRandomPointers newNode = new NodeWithRandomPointers(node.val);
        oldToNew.put(node, newNode);
        newNode.next = helper(node.next);
        newNode.random = helper(node.random);
        return newNode;
    }
}
