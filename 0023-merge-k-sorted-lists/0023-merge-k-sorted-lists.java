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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(ListNode head : lists){
            ListNode curr = head;
            while(curr != null){
                list.add(curr.val);
                curr =curr.next;
            }
        }

        Collections.sort(list);

        ListNode result = new ListNode(-1);
        ListNode temp = result;
        for(int val : list){
            ListNode newNode = new ListNode(val);
            temp.next = newNode;
            temp = temp.next;
        } 

        return result.next;
    }
}