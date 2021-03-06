/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        //计算链表的长度
        int size = 0;
        for(ListNode node = head; node != null; node = node.next){
            size++;
        }
        if(size < k){
            return head;
        }
        int pos = k;
        ListNode cur = head;
        ListNode newHead = null;
        ListNode prev = null;
        ListNode next = null;
        while(pos >= 1){
            next = cur.next;
            pos--;
            if(pos == 0){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ListNode last = newHead;
        while(last.next != null){
            last = last.next;
        }
        ListNode nextHead = reverseKGroup(next,k);
        last.next = nextHead;
        return newHead;
    }
}