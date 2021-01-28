package linked_list;

class Reverse {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();

        Reverse r = new Reverse();
        ListNode reversed = r.reverse(helper.getListWithNum(new int[]{2, 4, 3}));
        System.out.print("reversed : ");
        helper.printList(reversed);

        ListNode reversed2 = r.reverse(helper.getListWithNum(new int[]{1}));
        System.out.print("reversed : ");
        helper.printList(reversed2);
    }

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

}
