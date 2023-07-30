package monotone_stack;

import java.util.Stack;

public class _456模式132 {


    //输入：nums = [1,2,3,4]
    //输出：false
    //解释：序列中不存在 132 模式的子序列。

    // https://leetcode.cn/problems/132-pattern/
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;

        int two = Integer.MIN_VALUE;
        int three = Integer.MIN_VALUE;

        for (int i = n-1 ; i >= 0; i--) {
            // nums[i] 为 1
            if (nums[i] < two) {
                System.out.println("one:" + nums[i] + " three:" + three + "two:" + two);
                return true;
            }


            // 相当于找到了 3 和 2
            while (stack.size() > 0 && nums[i] > stack.peek()) {
                three = nums[i];
                two = stack.pop();
            }

            // 压栈
            stack.push(nums[i]);
        }
        return false;

    }

}
