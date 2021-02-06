package linked_list.singly;

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
        if (head == null) System.out.print("Null");
        while (head != null) {
            System.out.print(head.val + "-");
            head = head.next;
        }
        System.out.println("");
    }

    public boolean compare(ListNode l1, ListNode l2) {
        System.out.println("Comparing : ");
        printList(l1);
        printList(l2);
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return (l1 == null && l2 == null);
    }
}
