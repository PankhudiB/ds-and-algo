package linked_list.singly;

class OddEvenLinkedList {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();

        OddEvenLinkedList listUtility = new OddEvenLinkedList();
        System.out.print("list with odd even grouped nodes : ");
        helper.printList(listUtility.groupOddEvenNodes(helper.getListWithNum(new int[]{1, 2, 3, 4, 5})));

        System.out.print("list with odd even grouped nodes : ");
        helper.printList(listUtility.groupOddEvenNodes(helper.getListWithNum(new int[]{2, 1, 3, 5, 6, 4, 7})));

    }

    ListNode groupOddEvenNodes(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
