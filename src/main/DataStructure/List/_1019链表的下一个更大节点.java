package DataStructure.List;


// https://leetcode.cn/problems/next-greater-node-in-linked-list/description/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _1019链表的下一个更大节点 {


    @Test
    void test(){

        ListNode node = ListNode.buildList(new int[]{2, 1, 5});
        Assertions.assertEquals(Arrays.toString(nextLargerNodes(node)), "[5, 5, 0]");

        node = ListNode.buildList(new int[]{2,7,4,3,5});
        Assertions.assertEquals(Arrays.toString(nextLargerNodes(node)), "[7, 0, 5, 5, 0]");
    }



    /*
    *  下一个更大值 ---> 单调栈！！！
    *
    * */

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }

        int[] res = new int[len];



        // listnode ---> arr
        cur = head;
        int[] nums = new int[len];
        int index = 0;
        while (cur != null){
            nums[index++] = cur.val;
            cur = cur.next;
        }

        // 单调栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int flag = stack.pop();
                res[flag] = nums[i];
            }
            stack.push(i);
        }


        return res;
    }
}
