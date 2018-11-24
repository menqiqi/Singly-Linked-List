/**
 * 删除链表中等于给定值 val 的所有节点。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        if(head.next == null && head.val == val){
            return null;
        }
        ListNode node = head;
        ListNode prev = null;
        while(node != null  ){
            //第一个数字是删除的数字
            if(head.val == val){
                head = node.next;
                prev = node.next;
                node.next = null;
                node = prev;
            }
            else if(node.next != null && node.next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return head;
    }
}
