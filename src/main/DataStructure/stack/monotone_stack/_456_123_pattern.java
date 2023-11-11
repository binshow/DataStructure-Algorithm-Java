package DataStructure.stack.monotone_stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _456_123_pattern {

    //输入：nums = [1,2,3,4]
    //输出：false
    //解释：序列中不存在 132 模式的子序列。

    //输入：nums = [3,1,4,2]
    //输出：true
    //解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。

    // https://leetcode.cn/problems/132-pattern/



    @Test
    void test(){
        Assertions.assertEquals(find132pattern(new int[]{3,1,4,2}) , true);
        Assertions.assertEquals(find132pattern(new int[]{1,2,3,4}) , false);
        Assertions.assertEquals(find132pattern(new int[]{1,0,1,-4,-3}) , false);
    }

    /*
    * 思路： 132 模式 从后往前看， 2-3 是递增的，可以用单调栈的思路去解，只需要找到1就说明 132 存在
    *
    * */

    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int one = Integer.MIN_VALUE , two = Integer.MIN_VALUE  , three = Integer.MIN_VALUE ;
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] < two){
                System.out.println("one: " + nums[i] + " three: " + three + " two: " + two);
                return true;
            }
            while (!stack.empty() && stack.peek() < nums[i]){
                two = stack.pop();
                three = nums[i];
            }
            stack.push(nums[i]);
           // System.out.println(stack);
        }
        return false;
    }

}
