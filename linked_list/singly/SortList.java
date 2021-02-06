package linked_list.singly;

class SortList {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();
        SortList listUtility = new SortList();

        helper.printList(listUtility.sort(helper.getListWithNum(new int[]{3, 2, 1})));
        helper.printList(listUtility.sort(helper.getListWithNum(new int[]{1, 2, 3})));
        helper.printList(listUtility.sort(helper.getListWithNum(new int[]{5, 8, 2, 4, 1, 3})));
    }

    ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = findMiddleNode(head);
        ListNode left = sort(head);
        ListNode right = sort(middle);
        return merge(left,right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = (l1 == null) ? l2 : l1;
        return preHead.next;
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}
