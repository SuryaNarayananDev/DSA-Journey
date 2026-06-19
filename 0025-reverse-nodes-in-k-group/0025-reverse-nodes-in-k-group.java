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
        ListNode start = head;
        ListNode end = head;
        head = null;
        ListNode before = null;
        while(end != null){  
            end = kthnode(start, k);
            if(end == null){
                before.next = start;
                break;
            }
            ListNode next = null;
            if(end.next != null){
               next = end.next; 
            }
            end.next = null;
            
            reverse(start);
            if(head == null)
                head = end;
            else
                before.next = end;
            before = start;
            start = next;
            end = next;
        } 
        return head;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode kthnode(ListNode head, int k){
        ListNode temp = head;
        while(temp != null){
            if(k==1){
                return temp;
            }
            temp = temp.next;
            k--;
        }

        return null;
    }
}