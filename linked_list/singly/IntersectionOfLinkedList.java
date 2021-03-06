package linked_list.singly;

import java.util.HashSet;

class IntersectionOfLinkedList {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();

        IntersectionOfLinkedList listUtility = new IntersectionOfLinkedList();
        System.out.print("list with odd even grouped nodes : ");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node7.next = node8;
        node8.next = node9;
        node9.next = node3;

        ListNode nonIntersectingL1 = helper.getListWithNum(new int[]{1, 3, 5});
        ListNode nonIntersectingL2 = helper.getListWithNum(new int[]{6, 8, 5});


        System.out.println("getIntersection using set");
        System.out.println(listUtility.getIntersection(node1, node8) + "\n====================================");
        System.out.println(listUtility.getIntersection(nonIntersectingL1, nonIntersectingL2) + "\n=================================================================");

        System.out.println("getIntersection using count difference");
        System.out.println(listUtility.getIntersectionUsingCountDifference(node1, node8) + "\n====================================");
        System.out.println(listUtility.getIntersectionUsingCountDifference(nonIntersectingL1, nonIntersectingL2) + "\n=================================================================");

        System.out.println("getIntersection make loop in 1st and detect loop in 2nd");
        System.out.println(listUtility.getIntersectionMakeCircleIn1stAndFindLoopIn2nd(node1, node8) + "\n====================================");
        System.out.println(listUtility.getIntersectionMakeCircleIn1stAndFindLoopIn2nd(nonIntersectingL1, nonIntersectingL2) + "\n====================================");
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

    ListNode getIntersectionUsingCountDifference(ListNode head1, ListNode head2) {
        int count1 = count(head1);
        int count2 = count(head2);
        int diff = count2 - count1;
        if (count1 > count2)
            return getIntersection(diff, head1, head2);
        else return getIntersection(diff, head2, head1);
    }

    private ListNode getIntersection(int diff, ListNode larger, ListNode smaller) {
        ListNode curr1 = larger;
        ListNode curr2 = smaller;
        for (int i = 0; i < diff; i++) {
            if (curr1 == null) return null;
            curr1 = curr1.next;
        }
        while (curr1 != null && curr2 != null) {
            if (curr1.next == curr2.next) return curr1.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }

    private int count(ListNode head1) {
        int count = 0;
        while (head1 != null) {
            count++;
            head1 = head1.next;
        }
        return count;
    }

    ListNode getIntersectionMakeCircleIn1stAndFindLoopIn2nd(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        ListNode intersectingAt = null;
        int count1 = 0;
        while (curr1.next != null) {
            count1++;
            curr1 = curr1.next;
        }
        ListNode last = curr1;
        // create loop in first linked list
        curr1.next = head1;
        ListNode ptr = new ListNode(-1, curr2);
        for (int i = 0; i < count1; i++) {
            curr2 = curr2.next;
        }
        for (int i = 0; i < count1 && curr2.next != null; i++) {
            if (ptr == curr2) intersectingAt = curr2;
            ptr = ptr.next;
            curr2 = curr2.next;
        }
        last.next = null;
        return intersectingAt;
    }

}
