package linked_list.singly;

class IsPalindrome {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();
        IsPalindrome listUtility = new IsPalindrome();

        System.out.println(listUtility.isPalindrome(helper.getListWithNum(new int[]{1, 2, 1})) + "\n --------------------------------");
        System.out.println(listUtility.isPalindrome(helper.getListWithNum(new int[]{1, 2, 2, 1})) + "\n --------------------------------");
        System.out.println(listUtility.isPalindrome(helper.getListWithNum(new int[]{1, 2})) + "\n --------------------------------");
        System.out.println(listUtility.isPalindrome(helper.getListWithNum(new int[]{1, 2, 3, 2, 1})) + "\n --------------------------------");
        System.out.println(listUtility.isPalindrome(helper.getListWithNum(new int[]{0, 0})) + "\n --------------------------------");
    }

    boolean isPalindrome(ListNode head) {
        ListNode firstHalfLastNode = endOfFirstHalf(head);
        Reverse listUtility = new Reverse();
        ListNode reversedSecondHalf = listUtility.reverse(firstHalfLastNode.next);
        LinkedListHelper helper = new LinkedListHelper();

        //if list is even size - compare all
        // if odd size ignore comparing the middle element
        boolean result = true;
        while (result && reversedSecondHalf != null) {
            if (head.val != reversedSecondHalf.val) result = false;
            head = head.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }
        firstHalfLastNode.next = listUtility.reverse(reversedSecondHalf);
        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
