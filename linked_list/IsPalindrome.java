package linked_list;

class IsPalindrome {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();
        IsPalindrome listUtility = new IsPalindrome();

        System.out.println(listUtility.isPalindrome(helper.getListWithNum(new int[]{1, 2, 1})));
        System.out.println(listUtility.isPalindrome(helper.getListWithNum(new int[]{1, 2, 3, 1})));
        System.out.println(listUtility.isPalindrome(helper.getListWithNum(new int[]{1, 2})));
        System.out.println(listUtility.isPalindrome(helper.getListWithNum(new int[]{1, 2, 3, 2, 1})));
    }

    boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        Reverse listUtility = new Reverse();
        ListNode reversedSecondHalf = listUtility.reverse(mid);
        LinkedListHelper helper = new LinkedListHelper();
        return helper.compare(head, reversedSecondHalf);
    }
}
