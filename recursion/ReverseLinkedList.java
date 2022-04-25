package recursion;

import linked_list.singly.LinkedListHelper;
import linked_list.singly.ListNode;


public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ReverseLinkedList r = new ReverseLinkedList();
        LinkedListHelper h = new LinkedListHelper();
        h.printList(l1);
        ListNode reversed = r.reverse(l1);
        h.printList(reversed);
        ListNode original = r.reverse(reversed);
        h.printList(original);
    }

    public ListNode reverse(ListNode head) {
        return helper(head);
    }

    ListNode helper(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = helper(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    public ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
