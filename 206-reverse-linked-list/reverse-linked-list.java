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
    public ListNode reverse(ListNode head,ListNode prev){
        if(head==null)return prev;

        ListNode next=head.next;
        head.next=prev;
        prev=head;
        head=next;

        return reverse(head,prev);
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head,null);
    }
}