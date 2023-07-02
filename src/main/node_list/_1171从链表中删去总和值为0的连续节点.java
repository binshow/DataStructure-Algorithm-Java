package node_list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/279:22 AM
 */
public class _1171从链表中删去总和值为0的连续节点 {

    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1, 2, 3, -3, -2});

        System.out.println(ListUtil.println(head));
        ListNode res = removeZeroSumSublists(head);
        System.out.println(ListUtil.println(res));
    }



    // 找和为0的子数组 ---> 前缀和
    public static ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // key 为和 ， val 为最后一个节点
        Map<Integer , ListNode> map = new HashMap<>();

        int sum = 0;
        ListNode cur = dummy;
        while (cur != null){
            sum += cur.val;
            map.put(sum , cur); // 这里 同一个sum 会覆盖，也就是 value 为该sum出现的最后一个节点
            cur = cur.next;
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        sum = 0;
        cur = dummy;
        while (cur != null){
            sum += cur.val;
            cur.next = map.get(sum).next;
            cur = cur.next;
        }
        return dummy.next;
    }


    // 递归解法
    public ListNode removeZeroSumSublists2(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        //以head作为开头，是否存在一段以head开头的和为0的连续节点，如果存在的话，删去这段节点
        ListNode cur = head;
        while (cur != null){
            sum += cur.val;
            if (sum == 0) return removeZeroSumSublists2(cur.next);
            cur = cur.next;
        }
        //能到达这里说明不存在从head开始的一段和为0的连续节点，那么从head next开始
        head.next = removeZeroSumSublists2(head.next);
        return head;

    }

}
