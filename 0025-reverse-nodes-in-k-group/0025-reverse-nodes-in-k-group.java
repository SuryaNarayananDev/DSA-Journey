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
        if(head.next == null) return head;
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            arr.add(curr.val);
            curr =curr.next;
        }
        
        curr = head;
        int count = 1;
        int prev = 0;
        for(int i=0;i<arr.size();i++){
            if(count==k){
                swap(arr,prev,i);
                prev = i+1;
                count=1;
            }
            else{
                count++;
            }
        }

        count =0;
        curr = head;
        while(curr != null){
            curr.val = arr.get(count++);
            curr = curr.next;
        }

        return head;
    }


    public void swap(List<Integer> arr, int a, int b) {
        while (a < b) {
            int temp = arr.get(a);
            arr.set(a, arr.get(b));
            arr.set(b, temp);
            a++;
            b--;
        }
    }
}