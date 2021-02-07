package linked_list.doubly;

public class DListNode {
    int val;
    int key;
    DListNode prev;
    DListNode next;

    DListNode(int val) {
        this.val = val;
    }

    DListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

}