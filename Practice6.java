package www.singly.java;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while(slow != null && fast != null){
            if(slow.val == fast.val){
                ListNode cur = fast; //方便把它的下个节点置空
                fast = fast.next;
                cur.next = null;
                slow.next = fast;
            }else{
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }
}
