package linked_list;

import java.util.HashSet;
import java.util.Hashtable;

class IntersectionOfLinkedList {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();

        IntersectionOfLinkedList listUtility = new IntersectionOfLinkedList();
        System.out.print("list with odd even grouped nodes : ");
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node8.next = node9;
        node9.next = node3;
        System.out.println(listUtility.getIntersection(node1, node8));
        System.out.println(listUtility.getIntersection(helper.getListWithNum(new int[]{1, 3, 5}), helper.getListWithNum(new int[]{6, 8, 5})));
    }

    ListNode getIntersection(ListNode head1, ListNode head2) {
        HashSet<ListNode> visited = new HashSet<>();
        while (head1 != null) {
            visited.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (visited.contains(head2)) {
                return head2;
            }
            visited.add(head2);
            head2 = head2.next;
        }
        return null;
    }
}
