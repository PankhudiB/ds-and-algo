package linked_list;

class Merge2SortedLinkedLists {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();

        Merge2SortedLinkedLists listMerger = new Merge2SortedLinkedLists();
        int[] arr1 = new int[]{1, 2, 5, 6, 7};
        ListNode list1 = helper.getListWithNum(arr1);
        int[] arr2 = new int[]{3, 4, 5, 8, 9};
        ListNode list2 = helper.getListWithNum(arr2);

        ListNode mergedList = listMerger.merge(list1, list2);
        System.out.print("merged : ");
        helper.printList(mergedList);

        int[] arr3 = new int[]{1, 2, 4};
        ListNode list3 = helper.getListWithNum(arr3);
        int[] arr4 = new int[]{1, 3, 4};
        ListNode list4 = helper.getListWithNum(arr4);

        ListNode mergedList2 = listMerger.merge(list3, list4);
        System.out.print("merged : ");
        helper.printList(mergedList2);

        int[] emptyList = new int[]{};
        ListNode list5 = helper.getListWithNum(emptyList);
        int[] arr6 = new int[]{1};
        ListNode list6 = helper.getListWithNum(arr6);

        ListNode mergedList3 = listMerger.merge(list5, list6);
        System.out.print("merged : ");
        helper.printList(mergedList3);

        int[] emptyArr = new int[]{};
        ListNode list7 = helper.getListWithNum(emptyArr);
        int[] anotherEmptyList = new int[]{};
        ListNode list8 = helper.getListWithNum(anotherEmptyList);

        ListNode mergedList4 = listMerger.merge(list7, list8);
        System.out.print("merged : ");
        helper.printList(mergedList4);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        boolean evaluateHead = true;
        ListNode head = new ListNode();
        if (l1 == null && l2 == null) {
            return head.next;
        }
        if (l1 != null || l2 != null) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            }
        }
        if (evaluateHead && (l1 != null || l2 != null)) {
            if (l1.val < l2.val) head.next = l1;
            else head.next = l2;
            evaluateHead = false;
        }
        ListNode prev1 = new ListNode(0, l1);
        ListNode prev2 = new ListNode(0, l2);
        while (l1 != null || l2 != null) {
            if (l1.val >= l2.val) {
                while (l2 != null && l2.val <= l1.val) {
                    l2 = l2.next;
                    prev2 = prev2.next;
                }
                prev2.next = l1;
                prev2 = new ListNode(0, l2);
            } else {
                while (l1 != null && l1.val <= l2.val) {
                    l1 = l1.next;
                    prev1 = prev1.next;
                }
                prev1.next = l2;
                prev1 = new ListNode(0, l1);
            }
            if (l1 == null || l2 == null) break;
        }
        return head.next;
    }
}
