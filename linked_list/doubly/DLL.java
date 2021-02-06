package linked_list.doubly;

import util.Tuple;

public class DLL {
    DListNode head;

    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.addAtEnd(1);
        dll.addAtEnd(2);
        dll.addAtEnd(3);
        dll.printForwardAndBackward(dll.head);
        dll.addAtFront(0);
        System.out.println();
        dll.printForwardAndBackward(dll.head);
    }

    private void printForwardAndBackward(DListNode head) {
        DListNode curr = head;
        DListNode last = null;
        System.out.print("Fwd : ");
        while (curr != null) {
            System.out.print(curr.val + " --> ");
            last = curr;
            curr = curr.next;
        }
        System.out.print(" | Bckwd : ");
        while (last != null) {
            System.out.print(last.val + " --> ");
            last = last.prev;
        }
    }

    private void addAtEnd(int data) {
        DListNode new_node = new DListNode(data);
        DListNode last = head;

        if (head == null) {
            head = new_node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
        new_node.prev = last;
    }

    private void addAtFront(int data) {
        DListNode new_node = new DListNode(data);
        new_node.next = head;
        if (head != null)
            head.prev = new_node;

        head = new_node;
    }
}
