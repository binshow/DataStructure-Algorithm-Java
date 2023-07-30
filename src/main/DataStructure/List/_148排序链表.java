package DataStructure.List;


// https://leetcode.cn/problems/sort-list/

public class _148排序链表 {

    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{4, 1, 3, 8, 9, 6, 7, 10, 2, 9});
        ListNode res = sortList(head);
        ListNode.printList(res);
    }

    private static   ListNode sortList(ListNode head) {
        if (head == null) return null;
        return mergeSort(head , null);
    }

    private static ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == tail) return head;
        // 寻找中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode r = mergeSort(slow.next , tail);
        slow.next = null;
        ListNode l = mergeSort(head , slow);

        return merge(l , r);
    }

    private static ListNode merge(ListNode l, ListNode r) {
        if (l == null || r == null) return l == null ? r : l;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l != null && r != null){
            if (l.val < r.val){
                cur.next = new ListNode(l.val);
                l = l.next;
            }else {
                cur.next = new ListNode(r.val);
                r = r.next;
            }
            cur = cur.next;
        }

        cur.next = l == null ? r : l;
        return dummy.next;
    }
}
