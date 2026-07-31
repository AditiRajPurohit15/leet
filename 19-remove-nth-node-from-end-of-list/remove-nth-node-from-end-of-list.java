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
        ListNode prev=null;
        ListNode curr=head;
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        n=size-n+1;
        if(n==1)return head.next==null?null:head.next;
        int i=1;
        while(i<n && curr!=null){
            prev=curr;
            curr=curr.next;
            i++;
        }
        prev.next=curr.next;
        return head;
    }
}