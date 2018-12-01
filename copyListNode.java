/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深度拷贝。
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        //复制节点
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        //复制random
        cur = head;
        while(cur != null){
            if(cur.random == null){
                //随机指针指向空的情况
                cur.next.random = null;
            }else{
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //拆分
        cur = head;
        RandomListNode res = cur.next;
        while(cur != null){
            RandomListNode tmp = cur.next;
            cur.next = tmp.next;
            if(cur.next != null){
                tmp.next = cur.next.next;
            }else{
                tmp.next = null;
            }
            cur = cur.next;
        }
        return res;
    }
}