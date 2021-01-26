package linked_list;

class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        RemoveNthNodeFromEnd l = new RemoveNthNodeFromEnd();
        helper.printList(node1);
        ListNode modifiedHead = l.removeNthFromEnd(node1, 3);
        helper.printList(modifiedHead);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode nthPrevFromEnd = dummy;
        ListNode nthFromStart = dummy;

        for (int i = 1; i <= n + 1; i++) {
            nthFromStart = nthFromStart.next;
        }

        while (nthFromStart != null) {
            nthPrevFromEnd = nthPrevFromEnd.next;
            nthFromStart = nthFromStart.next;
        }

        nthPrevFromEnd.next = nthPrevFromEnd.next.next;

        return dummy.next;
    }
}
