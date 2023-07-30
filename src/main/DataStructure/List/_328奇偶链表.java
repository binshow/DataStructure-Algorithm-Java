package DataStructure.List;


// https://leetcode.cn/problems/odd-even-linked-list/

public class _328奇偶链表 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode a = head;
        ListNode b = head.next;

        ListNode tem = head.next;

        // a b c d

        // a b c d

        while (b != null && b.next != null){
            ListNode c = b.next;
            ListNode d = c.next;
            a.next = c;
            b.next = d;

            a = c;
            b = d;
        }

        a.next = tem;



        return head;

    }
}
