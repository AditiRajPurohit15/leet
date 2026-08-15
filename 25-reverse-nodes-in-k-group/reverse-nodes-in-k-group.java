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
    public void rev(ListNode start,ListNode end){
        ListNode stop=end.next;
        ListNode prev=null;
        ListNode curr=start;

        while(curr!=stop){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        //if k nodes - dummy.next=reverseK
        if(k==1)return head;
        if(head==null || head.next==null)return head;

        ListNode start=head;
        ListNode end=head;
        int index=k-1;
        while(index-->0){
            end=end.next;
            if(end==null)return head;
        }
        ListNode ans=reverseKGroup(end.next,k);
        rev(start,end);
        start.next=ans;
        return end;
    }
}