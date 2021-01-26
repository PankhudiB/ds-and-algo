package linked_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class RemoveNodesWithValueK {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        RemoveNodesWithValueK l = new RemoveNodesWithValueK();
        l.printList(node1);
        ListNode modifiedHead = l.removeNodesWithValueK(node1, 3);
        l.printList(modifiedHead);
    }

    ListNode removeNodesWithValueK(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null){
            if (current.val == k) {
                prev.next = current.next;
            }  else {
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }

    private void printList(ListNode head) {
        while (head != null){
            System.out.print(head.val + "-");
            head = head.next;
        }
        System.out.println();
    }

}
