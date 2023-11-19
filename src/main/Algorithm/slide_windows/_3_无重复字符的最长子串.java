package Algorithm.slide_windows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
public class _3_无重复字符的最长子串 {


    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    //
    //
    //
    //示例 1:
    //
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //示例 2:
    //
    //输入: s = "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //示例 3:
    //
    //输入: s = "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

    @Test
    void test(){
        Assertions.assertEquals(lengthOfLongestSubstring("abcabcbb") , 3);
        Assertions.assertEquals(lengthOfLongestSubstring("bbbbb") , 1);
        Assertions.assertEquals(lengthOfLongestSubstring("pwwkew") , 3);
    }



    // 思路：无固定大小的滑动窗口

    // 用一个map来保存窗口内的字符 及其出现的位置

    public int lengthOfLongestSubstring(String s) {
       int res = 0;
        Map<Character , Integer> map = new HashMap<>();
        // 两个指针 i在前 ，j在后
        for (int i = 0 , j = 0; i < s.length(); i++) {

            // 如果map 中存在当前元素a，更新 j 指针到 原来的a 后面一位
            if (map.containsKey(s.charAt(i))) j = Math.max(j , map.get(s.charAt(i)) + 1);

            // 记录当前元素的位置
            map.put(s.charAt(i) , i);

            // 更新结果集
            System.out.println("满足条件的子串: " + s.substring(j , i+1));
            res = Math.max(res , i - j + 1);

        }
        return res;
    }

}
