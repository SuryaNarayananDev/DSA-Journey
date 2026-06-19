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
    public ListNode rotateRight(ListNode head, int k) {

        // Empty list or no rotation needed
        if(head == null || k == 0 || head.next == null) return head;

        ListNode curr = head;

        // Stores the second part of the list after splitting
        ListNode secHalf = null;

        // Find length of linked list
        int n = count(head);

        // Remove unnecessary full rotations
        k = k % n;

        // Convert right rotation into split position
        k = n - k;

        // Move to the node just before split point
        while(curr != null){
            if(k == 1){
                break;
            }else{
                curr = curr.next;
                k--;
            }
        }

        // Original head becomes the tail of first half
        ListNode firstEnd = head;

        // Start of second half
        secHalf = curr.next;

        // Split list into two parts
        curr.next = null;

        // Reverse first half
        head = reverse(head);

        // Reverse second half
        secHalf = reverse(secHalf);

        // Join reversed halves
        firstEnd.next = secHalf;

        // Reverse entire list to get rotated result
        return reverse(head);
    }

    // Returns length of linked list
    public int count(ListNode head){
        ListNode curr = head;
        int counter = 0;

        while(curr != null){
            curr = curr.next;
            counter++;
        }

        return counter;
    }

    // Standard linked list reversal
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
}