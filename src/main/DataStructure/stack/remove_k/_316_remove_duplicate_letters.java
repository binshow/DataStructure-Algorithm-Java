package DataStructure.stack.remove_k;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _316_remove_duplicate_letters {

    //https://leetcode.cn/problems/remove-duplicate-letters/description/

    // 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
    // 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "bcabc"
    //输出："abc"
    //示例 2：
    //
    //输入：s = "cbacdcbc"
    //输出："acdb"



    @Test
    void test(){
        Assertions.assertEquals(removeDuplicateLetters("bcabc") , "abc");
        Assertions.assertEquals(removeDuplicateLetters("cbacdcbc") , "acdb");
    }

    /*
    *
    *
    *
    * */

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.contains(c)) continue; // 如果栈中已经包含了这个字符
            //  栈顶比当前元素大，且 后面还有栈顶的元素，栈顶的元素就可以弹出了!!!
            while (!stack.empty() && stack.peek() > c && findLast(s , stack.peek()) > i) stack.pop();
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }

    private int findLast(String s, Character c) {
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == c) return i;
        }
        return -1;
    }
}
