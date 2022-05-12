package linked_list.singly;

import tree.Node;

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

    public NodeWithRandomPointers copyRandomList(NodeWithRandomPointers node) {
        if (node == null) return null;
        if (oldToNew.containsKey(node)) return oldToNew.get(node);

        NodeWithRandomPointers newNode = new NodeWithRandomPointers(node.val);
        oldToNew.put(node, newNode);
        newNode.next = copyRandomList(node.next);
        newNode.random = copyRandomList(node.random);
        return newNode;
    }

    public NodeWithRandomPointers copyRandomListIterative(NodeWithRandomPointers head) {
        if (head == null) return null;
        NodeWithRandomPointers oldNode = head;
        NodeWithRandomPointers newNode = new NodeWithRandomPointers(oldNode.val);

        while (oldNode != null) {
            newNode.next = getClonedNode(oldNode.next);
            newNode.random = getClonedNode(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.oldToNew.get(head);
    }

    private NodeWithRandomPointers getClonedNode(NodeWithRandomPointers node) {
        if (node == null) return null;
        if (oldToNew.containsKey(node)) return oldToNew.get(node);
        NodeWithRandomPointers newNode = new NodeWithRandomPointers(node.val);
        oldToNew.put(node, newNode);
        return newNode;
    }
}
