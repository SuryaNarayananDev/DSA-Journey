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
        ListNode firstHead = headA;
        ListNode secondHead = headB;
        while(firstHead != secondHead){
            firstHead = (firstHead == null)?headB : firstHead.next;
            secondHead = (secondHead == null)?headA :secondHead.next;
        }

        return firstHead == secondHead? firstHead : null;
    }
}