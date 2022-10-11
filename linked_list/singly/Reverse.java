package linked_list.singly;

class Reverse {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();

        Reverse r = new Reverse();
        ListNode reversed = r.reverse(helper.getListWithNum(new int[]{2, 4, 3}));
        System.out.print("reversed : ");
        helper.printList(reversed);

        ListNode reversed2 = r.reverseRecursive(helper.getListWithNum(new int[]{1,2,3}));
        System.out.print("reversed : ");
        helper.printList(reversed2);
    }

    // TIP :
    // maintain 3 ptrs
    // Prev , Curr
    // in 1 iteration
    // store curr.next in Next
    // prev <--- curr.next
    // move ptrs forward
    // Prev = curr
    // Curr = Next
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // TIP
    // imagine end of list with 2 nodes and write recursive algo
    // keep recursively calling
    ListNode reverseRecursive(ListNode curr) {
        if (curr == null || curr.next == null) return curr;
        ListNode p = reverseRecursive(curr.next);
        curr.next.next = curr;
        curr.next = null;
        return p;
    }

}
