
/**
 *  将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null; //结果链表
        ListNode last = null; //结果链表的最后一个，方便尾插
        ListNode next = null; //遍历链表的下一个节点
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                //取l1的节点
                if(res != null){
                    next = l1.next;
                    last.next = l1;
                    l1.next = null;
                    last = l1;
                    l1 = next;
                }else{
                    next = l1.next;
                    res = l1;
                    l1.next = null;
                    last = l1;
                    l1 = next;
                }
            }else{
                //取l2的节点
                if(res != null){
                    next = l2.next;
                    last.next = l2;
                    l2.next = null;
                    last = l2;
                    l2 = next;
                }else{
                    next = l2.next;
                    res = l2;
                    l2.next = null;
                    last = l2;
                    l2 = next;
                }
            }
        }
        if(l1 == null){
            last = l2;
        }
        if(l2 == null){
            last = l1;
        }
        return res;
    }
}


