package DataStructure.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _02链表相加 {


    @Test
    void test(){

        Assertions.assertEquals(
                addTwoNumbers(ListNode.buildList(new int[]{1,2,3}),
                               ListNode.buildList(new int[]{4,5,6})).toString(),
                ListNode.buildList(new int[]{5,7,9}));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }
}
