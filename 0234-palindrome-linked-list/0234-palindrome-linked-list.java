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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //  find the middle
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr = slow;
        ListNode prev = null;
        
        // reverse after the middle node
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode secondHead = prev;
        ListNode firstHead = head;

        // check this palidrom or not

        while(secondHead != null){
            if(firstHead.val != secondHead.val)
                return false;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        return true;
    }
}