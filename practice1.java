/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 *
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode node = head;
        head = head.next;
        while(node != null){
            ListNode res = node.next;
            if(res != null){
                ListNode tmp = res.next;
                if(tmp == null || tmp.next == null){
                    node.next = tmp;
                }else{
                    node.next = tmp.next;
                }
                res.next = node;
                node = tmp;
            }else{
                break;
            }

        }
        return head;
    }
}