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
    public ListNode sortList(ListNode head) {
        return mergesort(head);
    }

    public ListNode mergesort(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);

        ListNode right = mergesort(middle.next);
        middle.next = null;
        ListNode left = mergesort(head);

        return mergeListNode(left,right); 
    }

    public ListNode mergeListNode(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1,null);
        ListNode temp = dummy; 
        while(left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                left = left.next;
            }else{
                temp.next = right;
                right = right.next;
            }

            temp = temp.next;
        }

        if(left != null){
            temp.next = left;
        }

        if(right != null){
            temp.next = right;
        }

        return dummy.next;
    }

    public ListNode findMiddle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}