package recursion;

import linked_list.singly.ListNode;
import linked_list.singly.LinkedListHelper;


public class SwapNodesInPair {
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

        SwapNodesInPair r = new SwapNodesInPair();
        ListNode swappedList = r.swapPairs(l1);
        LinkedListHelper h = new LinkedListHelper();
        h.printList(swappedList);
    }

    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    ListNode helper(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        ListNode nextsNext = next.next;
        next.next = head;
        head.next = helper(nextsNext);
        return next;
    }
}
