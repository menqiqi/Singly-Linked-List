/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 *     get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 *     addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *     addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *     addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 *     deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */

class MyLinkedList {
    int size;
    ListNode head;
    ListNode tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index > size-1){
            return -1;
        }
        int count = 0;
        ListNode tmp = head;
        //while(index != count){
        //  tmp = tmp.next;
        //count++;
        //}
        for(tmp = head; tmp != null; tmp = tmp.next){
            if(count == index){
                return tmp.val;
            }
            count++;
        }
        return 0;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head == null){
            head = new ListNode(val);
            tail = head;
            size++;
        }else{
            ListNode tmp = new ListNode(val);
            tmp.next = head;
            head.prev = tmp;
            head = tmp;
            size++;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null){
            head = new ListNode(val);
            tail = head;
            size++;
        }else{
            ListNode tmp = new ListNode(val);
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
            size++;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }
        else if(index == size){
            addAtTail(val);
            return;
        }
        else if(index < size){
            //找到第index个节点
            int count = 0;
            ListNode cur = head;
            for(ListNode tmp = head; tmp != null; tmp = tmp.next){
                if(count == index){
                    cur = tmp;
                    break;
                }
                count++;
            }
            ListNode newNode = new ListNode(val);
            cur.prev.next = newNode;
            newNode.prev = cur.prev;
            newNode.next = cur;
            cur.prev = newNode;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index > size-1){
            return;
        }else if(index == 0){
            head = head.next;
            size--;
        }else if(index == size-1){
            tail = tail.prev;
            size--;
        }else{
            //找到第index个节点
            int count = 0;
            ListNode cur = null;
            for(ListNode tmp = head; tmp != null; tmp = tmp.next){
                if(count == index){
                    cur = tmp;
                    break;
                }
                count++;
            }
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
        }
    }

    class ListNode{
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
