/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *
 * 给定的 n 保证是有效的。
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //如果要删除的节点是第一个
        int size = 0;
        for(ListNode tmp = head; tmp != null; tmp = tmp.next){
            size++;
        }
        if(size == n){
            //头删
            head = head.next;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(n > 0){
            n--;
            fast = fast.next;
        }
        //记录要删除节点的前一个
        ListNode prev = null;
        while(fast != null){
            fast = fast.next;
            prev = slow;
            //slow就是要删除的节点
            slow = slow.next;
        }
        prev.next = slow.next;
        slow.next = null;
        return head;
    }
}