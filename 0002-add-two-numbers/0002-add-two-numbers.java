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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy; 
        int carry = 0;
        while(temp1 != null && temp2 != null){
            int sum = temp1.val + temp2.val + carry;
            if(sum < 10){
                ListNode newNode = new ListNode(sum);
                curr.next = newNode;
                carry =0 ;
            }else{
                ListNode newNode = new ListNode(sum%10);
                curr.next = newNode;
                carry = 1; 
            }
            curr = curr.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        

        while(temp1 != null ){
            int sum = temp1.val + carry;
            if(sum < 10){
                ListNode newNode = new ListNode(sum);
                curr.next = newNode;
                carry=0; 
            }else{
                ListNode newNode = new ListNode(sum %10);
                curr.next=newNode;
                carry = 1;
            }
            temp1 = temp1.next;
            curr = curr.next;
        }

         while(temp2 != null ){
            int sum = temp2.val + carry;
            if(sum < 10){
                ListNode newNode = new ListNode(sum);
                curr.next = newNode;
                carry=0; 
            }else{
                ListNode newNode = new ListNode(sum %10);
                curr.next=newNode;
                carry = 1;
            }
            temp2 = temp2.next;
            curr = curr.next;
        }

        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }

        return dummy.next;

        }

    
}