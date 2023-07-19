package listnode;


// https://leetcode.cn/problems/reverse-linked-list-ii/

public class _92翻转链表v2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 先找到要翻转节点的前一个
        ListNode cur = dummy;
        for (int i = 1; i < left; i++) {
            cur = cur.next;
        }

        System.out.println(cur.val);

        // tail 记录一下翻转后的尾节点，方便接上
        ListNode tail = cur.next;


        // 从节点node开始翻转
        ListNode node = cur.next;
        cur.next = null;
        ListNode pre = null;
        ListNode help = null;
        for (int i = left; i <= right; i++) {
            help = node.next;
            node.next = pre;
            pre = node;
            node = help;
        }

        // 翻转之后的头节点是 pre ， 尾结点是 tail , help 就是后面一个
        cur.next = pre;
        tail.next = help;

        return dummy.next;
    }

}
