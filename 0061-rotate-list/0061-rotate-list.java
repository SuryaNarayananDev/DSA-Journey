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
        if(head == null || k==0) return head;
        ListNode curr = head;
        ListNode secHalf = null;
        int n = count(head);
        k = k%n;
        k=n-k;
        while(curr != null){
            if(k==1){
                ListNode firstEnd = head;
                secHalf = curr.next;
                curr.next = null;
                head = reverse(head);
                secHalf = reverse(secHalf);
                firstEnd.next = secHalf;
                break;
            }else{
                curr = curr.next;
                k--;
            }
        }
        return reverse(head);
    }

    public int count(ListNode head){
        ListNode curr = head;
        int counter = 0;
        while(curr != null){
            curr = curr.next;
            counter++;
        }

        return counter;
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
}