package DataStructure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _394_decode_string {

    //https://leetcode.cn/problems/decode-string/description/

    //给定一个经过编码的字符串，返回它解码后的字符串。
    //
    //编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
    //
    //你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
    //
    //此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

    //示例 1：
    //
    //输入：s = "3[a]2[bc]"
    //输出："aaabcbc"
    //示例 2：
    //
    //输入：s = "3[a2[c]]"
    //输出："accaccacc"
    //示例 3：
    //
    //输入：s = "2[abc]3[cd]ef"
    //输出："abcabccdcdcdef"
    //示例 4：
    //
    //输入：s = "abc3[cd]xyz"
    //输出："abccdcdcdxyz"

    @Test
    void test(){
        Assertions.assertEquals(decodeString("3[a]2[bc]") , "aaabcbc");
        Assertions.assertEquals(decodeString("2[abc]3[cd]ef") , "abcabccdcdcdef");
        Assertions.assertEquals(decodeString("abc3[cd]xyz") , "abccdcdcdxyz");
        Assertions.assertEquals(decodeString("13[leetcode]") , "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode");
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == ']'){
                StringBuilder sb = new StringBuilder();
                while (!stack.empty() && stack.peek() != '[') sb.append(stack.pop());
                stack.pop(); // 弹出 [

                StringBuilder tmp = new StringBuilder();
                while (!stack.empty() && stack.peek() >= '0' && stack.peek() <= '9') tmp.append(stack.pop());
                int cur = Integer.parseInt(tmp.reverse().toString());

                // System.out.println(cur);
                for (int i = 0; i < cur; i++) {
                    for (int j = sb.length()-1; j >= 0; j--) {
                        stack.push(sb.charAt(j));
                    }
                }
            }else stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) sb.append(stack.pop());
        return sb.reverse().toString();

    }
}
