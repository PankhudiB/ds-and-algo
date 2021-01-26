package linked_list;

public class LinkedListHelper {
    public ListNode getListWithNum(int[] arr) {
        ListNode head = null;
        ListNode curr = null;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            if (head == null) {
                curr = node;
                head = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }
        }

        printList(head);
        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-");
            head = head.next;
        }
        System.out.println();
    }
}
