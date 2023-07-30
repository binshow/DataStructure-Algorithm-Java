package DataStructure.List;


// https://leetcode.cn/problems/reorder-list/

public class _143重排链表 {


    public static void main(String[] args) {

        ListNode head = ListNode.buildList(new int[]{1, 2, 3, 4 });
        head.printList(head);

        reorderList(head);

        head.printList(head);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. 先找链表中点，断开链表
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println(slow.val);

        ListNode temp = slow.next;
        slow.next = null;


        // 2. 翻转temp链表
        ListNode b = reverse(temp);
        ListNode a = head;


        // 3. 合并 a 和 b 两个链表
        // a c
        // b d
        // while(a.next != null && b.next != null) 就错了！！！
        while (a != null && b != null ){
            ListNode c = a.next;
            ListNode d = b.next;

            a.next = b;
            b.next = c;


            a = c;
            b = d;
        }
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode help = cur.next;
            cur.next = pre;
            pre = cur;
            cur = help;
        }
        return pre;
    }

}
