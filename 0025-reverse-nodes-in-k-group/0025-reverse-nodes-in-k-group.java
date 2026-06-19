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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null || k == 1) return head;
        boolean firstHead = true;
        ListNode start = head;
        ListNode end = head;
        ListNode before = null;
        int counter = 1;

        while(end != null){
            if(counter == k){
                ListNode next = end.next;
                end.next = null;
                ListNode reverseHead = reverse(start);
                
                if(firstHead){
                    head = reverseHead;
                    firstHead = false;
                }else{
                    before.next = reverseHead;
                    
                }
                start.next = next;
                before = start;
                start = next;
                end = next;
                counter = 1;
                continue;
            }
            end = end.next;
            counter++;  
        }

        return head;
    }

    public ListNode reverse(ListNode chunk){
        ListNode curr = chunk;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}