package linked_list.doubly;

import tree.Node;
import util.Tuple;

public class Traverser {
    DListNode head;
    public static void main(String[] args) {
        Tuple<DListNode, DListNode> headAndTail = getDoublyLinkedList();
        Traverser traverser = new Traverser();
        traverser.printForwardAndBackward(headAndTail);
    }

    private void printForwardAndBackward(Tuple<DListNode, DListNode> headAndTail) {
        System.out.println("fwd : ");
        forward(headAndTail.first);
        System.out.print("| bckwd : ");
        backward(headAndTail.second);
    }

    private void forward(DListNode head) {
        DListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " --> ");
            curr = curr.next;
        }
    }

    private void backward(DListNode tail) {
        DListNode curr = tail;
        while (curr != null) {
            System.out.print(curr.val + " --> ");
            curr = curr.prev;
        }
    }

    private static Tuple<DListNode, DListNode> getDoublyLinkedList() {
        DListNode node1 = new DListNode(1);
        DListNode node2 = new DListNode(2);
        DListNode node3 = new DListNode(3);
        DListNode node4 = new DListNode(4);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        return new Tuple<>(node1, node4);
    }

}
