package DataStructure.stack.parentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class _32_longest_valid_parentheses {


    @Test
    void test(){
        Assertions.assertEquals(longestValidParentheses(")()())") , 4);
        Assertions.assertEquals(longestValidParentheses("(()") , 2);
        Assertions.assertEquals(longestValidParentheses("") , 0);
    }

    // 最长有效括号

    // Given a string containing just the characters '(' and ')',
    // return the length of the longest valid (well-formed) parentheses substring.

    // Input: s = ")()())"
    // Output: 4 Explanation: The longest valid parentheses substring is "()()".

    // 有效位置记为0，无效位置记为1
    public int longestValidParentheses(String s) {
        int[] nums = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (stack.empty()) nums[i] = 1;
                else stack.pop();
            }
        }
        while (!stack.empty()) nums[stack.pop()] = 1;

       // System.out.println("转换成数组: " + Arrays.toString(nums));

        // 求最长连续0的个数
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count++;
            else count = 0;

            res = Math.max(res , count);
        }
        return res;
    }
}
