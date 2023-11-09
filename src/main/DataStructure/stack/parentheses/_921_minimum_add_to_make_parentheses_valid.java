package DataStructure.stack.parentheses;

import java.util.Stack;

public class _921_minimum_add_to_make_parentheses_valid {


    //只有满足下面几点之一，括号字符串才是有效的：
    //
    //它是一个空字符串，或者
    //它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
    //它可以被写作 (A)，其中 A 是有效字符串。
    //给定一个括号字符串 s ，在每一次操作中，你都可以在字符串的任何位置插入一个括号
    //
    //例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
    //返回 为使结果字符串 s 有效而必须添加的最少括号数。


    public int minAddToMakeValid(String s) {

        // 求出 字符串中 有效的位置
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

        // 求所有1的个数，无效的 1 就需要 添加一个括号来达到有效
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) res++;
        }
        return res;
    }
}
