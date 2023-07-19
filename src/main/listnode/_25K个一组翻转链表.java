package listnode;


// https://leetcode.cn/problems/reverse-nodes-in-k-group/

public class _25K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) return head;
            cur = cur.next;
        }

        ListNode res = reverse(head , cur);
        head.next = reverseKGroup(cur , k);
        return res;

    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail){
            ListNode help = cur.next;
            cur.next = pre;
            pre = cur;
            cur = help;
        }
        return pre;
    }

}
