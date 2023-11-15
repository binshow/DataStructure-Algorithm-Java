package DataStructure.stack.monotone_stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class _503_next_greater_element_v2 {


    //https://leetcode.cn/problems/next-greater-element-ii/description/

    //给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
    //
    //数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [1,2,1]
    //输出: [2,-1,2]
    //解释: 第一个 1 的下一个更大的数是 2；
    //数字 2 找不到下一个更大的数；
    //第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
    //示例 2:
    //
    //输入: nums = [1,2,3,4,3]
    //输出: [2,3,4,-1,4]


    @Test
    void test(){
        Assertions.assertEquals(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})),  "[2, 3, 4, -1, 4]");
        Assertions.assertEquals(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})),  "[2, -1, 2]");
    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        // from left to right , 单调递增
        // 第一个数也要填充，因此可以遍历两遍，注意下标转换
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n ;
            while (!stack.empty() &&  nums[stack.peek()] < nums[index]){  // 右边的数比当前数大
                //stack.pop();
                res[stack.pop()] = nums[index];
            }
            if (i < n) stack.push(i);
        }

        return res;
    }

}
