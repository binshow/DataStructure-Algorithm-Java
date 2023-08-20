package DataStructure.List;


/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/269:23 AM
 */
public class _876链表的中间节点 {

    public ListNode middleNode(ListNode head) {
        if(head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
}
