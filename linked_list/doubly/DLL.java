package linked_list.doubly;

public class DLL {
    DListNode head;
    DListNode tail;
    int size;

    public DLL() {
        head = tail;
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.addAtEnd(1);
        dll.addAtEnd(2);
        dll.addAtEnd(3);
        dll.forwardAndBackward();

        dll.addAtFront(0);
        dll.forwardAndBackward();

        dll.insertAfter(dll.head.next, 9);
        dll.forwardAndBackward();

        dll.insertBefore(dll.head.next, 33);
        dll.forwardAndBackward();

        System.out.println("\ndeleting :" + dll.head.next.val);
        dll.delete(dll.head.next);
        dll.forwardAndBackward();

        dll.delete(dll.head);
        dll.forwardAndBackward();

        dll.delete(dll.tail);
        dll.forwardAndBackward();
    }

    public void forwardAndBackward() {
        forward();
        System.out.print(" | ");
        backward();
        System.out.println(" | h :" + this.head.val + " t :" + this.tail.val);
    }

    public void forward() {
        DListNode curr = this.head;
        while (curr != null) {
            System.out.print(curr.val + " --> ");
            curr = curr.next;
        }
    }

    private void backward() {
        DListNode curr = this.tail;
        while (curr != null) {
            System.out.print(curr.val + " --> ");
            curr = curr.prev;
        }
    }

    public void addAtEnd(int data) {
        size++;
        DListNode new_node = new DListNode(data);
        DListNode last = head;

        if (head == null) {
            head = new_node;
            tail = new_node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
        new_node.prev = last;
        tail = new_node;
    }

    public void addAtFront(int data) {
        size++;
        DListNode new_node = new DListNode(data);
        new_node.next = head;
        if (head != null)
            head.prev = new_node;

        head = new_node;
    }

    public void addAtFront(DListNode new_node) {
        size++;
        new_node.next = head;
        if (head != null)
            head.prev = new_node;
        if (head == null) {
            tail = new_node;
        }
        head = new_node;
    }

    public void insertAfter(DListNode prev_Node, int data) {
        size++;
        DListNode new_node = new DListNode(data);
        new_node.next = prev_Node.next;
        new_node.prev = prev_Node;
        if (prev_Node.next != null) {
            prev_Node.next.prev = new_node;
        }
        prev_Node.next = new_node;
        if (prev_Node == tail)
            tail = new_node;
    }

    public void insertBefore(DListNode next_Node, int data) {
        size++;
        DListNode new_node = new DListNode(data);
        if (next_Node == head) {
            head = new_node;
            next_Node.prev = new_node;
            return;
        }
        new_node.prev = next_Node.prev;
        next_Node.prev.next = new_node;
        next_Node.prev = new_node;
        new_node.next = next_Node;

    }

    public void delete(DListNode del) {
        size--;
        if (del == null || head == null) return;
        if (del.next != null) {
            del.next.prev = del.prev;
        }
        if (del.prev != null) {
            del.prev.next = del.next;
        }
        if (del == head) {
            head = del.next;
        }
        if (del == tail) {
            tail = del.prev;
        }
        del.next = null;
        del.prev = null;
    }

    public int size() {
        return this.size;
    }
}
