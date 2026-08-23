/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int prevIndex=size-n-1;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        temp=dummy;
        for(int i = 0; i <= prevIndex; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return dummy.next;

    }
}