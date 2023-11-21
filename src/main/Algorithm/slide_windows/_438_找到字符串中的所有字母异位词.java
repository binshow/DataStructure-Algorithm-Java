package Algorithm.slide_windows;

// https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class _438_找到字符串中的所有字母异位词 {


    //给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    //
    //异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
    //
    //
    //
    //示例 1:
    //
    //输入: s = "cbaebabacd", p = "abc"
    //输出: [0,6]
    //解释:
    //起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    //起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
    // 示例 2:
    //
    //输入: s = "abab", p = "ab"
    //输出: [0,1,2]
    //解释:
    //起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
    //起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
    //起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。



    @Test
    void test(){

    }


    /*
    *  思路：固定大小的滑动窗口
    *  优化解法： 同 76 题
    *
    * */

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int k = p.length();
        for (int i = 0 , j = k ; j <= s.length(); i++ , j++) {
            String cur = s.substring(i , j);
            System.out.println(cur);
            if (check(p , cur)) res.add(i);
        }
        return res;
    }

    // 判断是否是 字母异位词
    private boolean check(String p, String s) {
        int[] count = new int[26];
        for (char c : p.toCharArray()) count[c - 'a']++;
        for (char c : s.toCharArray()) count[c - 'a']--;
        for (int num : count){
            if (num != 0) return false;
        }
        return true;
    }


}
