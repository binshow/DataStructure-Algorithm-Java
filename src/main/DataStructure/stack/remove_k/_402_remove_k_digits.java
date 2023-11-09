package DataStructure.stack.remove_k;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _402_remove_k_digits {

    //https://leetcode.cn/problems/remove-k-digits/description/

    //给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
    //
    //
    //示例 1 ：
    //
    //输入：num = "1432219", k = 3
    //输出："1219"
    //解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
    //示例 2 ：
    //
    //输入：num = "10200", k = 1
    //输出："200"
    //解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
    //示例 3 ：
    //
    //输入：num = "10", k = 2
    //输出："0"
    //解释：从原数字移除所有的数字，剩余为空就是 0 。

    @Test
    void test(){
        Assertions.assertEquals(removeKdigits("1432219" , 3) , "1219");
        Assertions.assertEquals(removeKdigits("10200" , 1) , "200");
        Assertions.assertEquals(removeKdigits("10" , 2) , "0");
        Assertions.assertEquals(removeKdigits("10001" , 2) , "0");
    }



    // 从左到右遍历数字 ，如 1432219
    // 遇到了4，由于 4 比左侧相邻的 1 大。如果选择丢弃左侧的 1，那么会使得剩下的数字更大（开头的数从 1 变成了 4）。因此我们仍然选择不丢弃。
    //         由于 3 比左侧相邻的 4 小。 如果选择丢弃左侧的 4，那么会使得剩下的数字更小（开头的数从 4 变成了 3）。因此我们选择丢弃。
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.empty() && stack.peek() > c){
                stack.pop();
                k--;
            }
            if (c == '0' && stack.empty()) continue;
            stack.push(c);
        }

        //如果 k 仍然大于 0。不妨假设最终还剩下 x 个需要丢弃，那么我们需要选择删除末尾 x 个元素。
        while (k > 0 && !stack.empty()){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) sb.append(stack.pop());
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }

    /*
    *  丢弃k个使得剩下的数字最小 ===> 保留 n-k 个元素
    * */
    public String removeKdigitsV2(String num, int k) {
        if (num.length() == k) return "0";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.empty() && stack.peek() > c){
                stack.pop();
                k--;
            }
            if (c == '0' && stack.empty()) continue; // 丢弃前导0
            stack.push(c);
        }
        while (stack.size() > num.length() - k) stack.pop();
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) sb.append(stack.pop());
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
