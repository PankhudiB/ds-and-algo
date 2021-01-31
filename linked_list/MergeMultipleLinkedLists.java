package linked_list;

class MergeMultipleLinkedLists {
    public static void main(String[] args) {
        LinkedListHelper helper = new LinkedListHelper();
        MergeMultipleLinkedLists listUtility = new MergeMultipleLinkedLists();
        ListNode[] lists = new ListNode[]{
                helper.getListWithNum(new int[]{1, 4, 5}),
                helper.getListWithNum(new int[]{1, 3, 4}),
                helper.getListWithNum(new int[]{2, 6})
        };
        ListNode mergedList = listUtility.mergeAll(lists);
        helper.printList(mergedList);

    }

    ListNode mergeAll(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode merged = lists[0];
        for (int i = 1; i < lists.length; i++) {
            merged = merge(merged, lists[i]);
        }
        return merged;
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = (l1 == null) ? l2 : l1;
        return preHead.next;
    }

    ListNode mergeDivideAndConquer(ListNode[] lists) {
        int last = lists.length - 1;
        int i = 0;
        int j = last;

        while (last != 0) {
            while (i < j) {
                lists[i] = merge(lists[i], lists[j]);
                i++;
                j--;
                if (i >= j) {
                    last = j;
                }
            }
        }
        return lists[0];
    }
}
