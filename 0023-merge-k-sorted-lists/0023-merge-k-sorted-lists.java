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

        if(lists.length < 0) return null;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode curr = lists[i];

            while(curr != null){
                list.add(curr.val);
                curr = curr.next;
            }
        }

        Collections.sort(list);

        ListNode head = new ListNode();

        ListNode curr = head;

        for(int i=0;i<list.size();i++){
            ListNode newNode = new ListNode(list.get(i));
            curr.next = newNode;
            curr = curr.next;
        }

        return head.next;
       
    }
}