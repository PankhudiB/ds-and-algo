package recursion;

import linked_list.singly.LinkedListHelper;
import linked_list.singly.ListNode;


public class Merge2SortedLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(10);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode ll1 = new ListNode(2);
        ListNode ll2 = new ListNode(3);
        ListNode ll3 = new ListNode(4);
        ListNode ll4 = new ListNode(7);
        ListNode ll5 = new ListNode(14);
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;
        ll4.next = ll5;

        Merge2SortedLinkedList r = new Merge2SortedLinkedList();
        ListNode mergedList = r.mergeRecursive(l1, ll1);
        LinkedListHelper h = new LinkedListHelper();
        h.printList(mergedList);
    }

    private ListNode mergeRecursive(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeRecursive(l1.next, l2);
            return l1;
        }
        l2.next = mergeRecursive(l1, l2.next);
        return l2;
    }

}
