package DataStructure.List;


import org.junit.jupiter.api.Test;

import java.util.*;

// https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
public class _1171从链表中删除总和值为0的连续节点 {

    @Test
    void test(){
        //[1,2,-3,3,1] ---> [3,1] or [1,2,1]

        System.out.println(removeZeroSum(Arrays.asList(1, 2, -3, 3, 1)));
    }

    // 前缀和解法
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return head;


        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        Map<Integer , ListNode> map = new HashMap<>();
        int sum = 0;
        while (cur != null){
            sum += cur.val;
            map.put(sum , cur);
            cur = cur.next;
        }

        cur = dummy;
        sum = 0;
        while (cur != null){
            sum += cur.val;
            cur.next = map.get(sum).next;
            cur = cur.next;
        }

        return head;
    }


    public List<Integer> removeZeroSum(List<Integer> list){

        LinkedList<Integer> linkedList = new LinkedList<>();
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , -1);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            map.put(sum , i);
        }

        sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);


        }
        return list;
    }

}
