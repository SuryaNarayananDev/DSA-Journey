/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode fast = headA;
        ListNode slow = headB;

        while(fast != slow){
           fast=(fast==null)?headA:fast.next;
           slow=(slow==null)?headB:slow.next;            
        }

        return fast;
    }
}