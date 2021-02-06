package linked_list.doubly;

public class DListNode {
    int val;
    DListNode prev;
    DListNode next;

    DListNode(int val) {
        this.val = val;
    }

    DListNode(int val, DListNode prev, DListNode next) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "DListNode{" +
                "val=" + val +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}