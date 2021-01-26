package linked_list;

class GfG
{
    public ListNode reverse(ListNode head, int k)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while(count < k && curr != null){
            next = curr.next;
            curr.next = prev;    
            prev = curr;
            curr = next;
            count++;
        }
        if(next != null){
            head.next = reverse(next,k);
        }
        return prev;
    }
}

