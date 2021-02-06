package linked_list.singly;

class AddNumber {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();

        AddNumber addNumber = new AddNumber();
        int[] arr342 = new int[]{2, 4, 3};
        ListNode num342 = helper.getListWithNum(arr342);
        int[] arr465 = new int[]{5, 6, 4};
        ListNode num465 = helper.getListWithNum(arr465);

        ListNode sumList = addNumber.add(num342, num465);
        System.out.print("sum : ");
        helper.printList(sumList);

        int[] arr999 = new int[]{9, 9, 9};
        ListNode num999 = helper.getListWithNum(arr999);
        int[] arr9999999 = new int[]{9, 9, 9, 9, 9, 9, 9};
        ListNode num9999999 = helper.getListWithNum(arr9999999);
        ListNode sum = addNumber.add(num9999999, num999);
        System.out.print("sum : ");
        helper.printList(sum);
    }

    ListNode add(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode curr = null;
        while (l1 != null || l2 != null) {
            int l1val = (l1 != null) ? l1.val : 0;
            int l2val = (l2 != null) ? l2.val : 0;
            int sum = l1val + l2val + carry;
            carry = (sum > 9) ? 1 : 0;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            if (head == null) {
                curr = node;
                head = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            curr.next = new ListNode(carry);
        }
        return head;
    }

}
