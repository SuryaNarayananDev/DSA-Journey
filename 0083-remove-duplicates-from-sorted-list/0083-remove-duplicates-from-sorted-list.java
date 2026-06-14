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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
	    
        ListNode pos = head;
        ListNode curr = head;

        while(curr != null){
            if(pos.val != curr.val){
                pos.next = curr;
                pos = pos.next;
            }
            curr = curr.next;
        }

        pos.next = null;

        return head;
    }
}