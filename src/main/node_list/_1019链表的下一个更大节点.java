package node_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/next-greater-node-in-linked-list/
 * @date 2023/6/269:26 AM
 */
public class _1019链表的下一个更大节点 {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }

        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)){
                Integer index = stack.pop();
                nums[index] = i;

            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(nums));
        return nums;

    }
}
