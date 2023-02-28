package node_list;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/merge-in-between-linked-lists/
 * @date 2023/1/309:14 PM
 */
public class Merge_In_Between_Linked_Lists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null || list2 == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;

        ListNode cur = list1;
        while (b > 0) {
            cur = cur.next;
            b--;
        }

        ListNode tem = cur.next;

        cur = dummy;
        while (a > 0) {
            cur = cur.next;
            a--;
        }
        cur.next = null;
        cur.next = list2;
        while (cur.next != null) cur = cur.next;
        cur.next = tem;
        return dummy.next;

    }

}
