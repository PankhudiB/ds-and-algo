package linked_list.singly;

class DetectCycle {
    public static void main(String[] args) {
        DetectCycle l = new DetectCycle();
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l3;

        System.out.print("has cycle : " + l.detectCycle(head) + "\n\n");
        LinkedListHelper helper = new LinkedListHelper();
        System.out.print("has cycle : " + l.detectCycle(helper.getListWithNum(new int[]{1, 2, 1})));
    }

    ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }

}