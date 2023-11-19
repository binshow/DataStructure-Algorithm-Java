package Algorithm.slide_windows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/minimum-window-substring/description/
public class _76最小覆盖子串 {

    //给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    //
    //
    //
    //注意：
    //
    //对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    //如果 s 中存在这样的子串，我们保证它是唯一的答案。
    //
    //
    //示例 1：
    //
    //输入：s = "ADOBECODEBANC", t = "ABC"
    //输出："BANC"
    //解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
    //示例 2：
    //
    //输入：s = "a", t = "a"
    //输出："a"
    //解释：整个字符串 s 是最小覆盖子串。
    //示例 3:
    //
    //输入: s = "a", t = "aa"
    //输出: ""
    //解释: t 中两个字符 'a' 均应包含在 s 的子串中，
    //因此没有符合条件的子字符串，返回空字符串。



    /*
    * 思路： 子串问题，复合单调性： [i , j] 之间满足条件 ，则 [i之前 ， j] 的子串就可以不用看了
    *       因此可以用滑动窗口
    *
    * 如何判断满足条件？
    *   一个map 维护 t 中所有字符 及其个数， 另外一个map 维护窗口中的所有字符及其个数，当两个map相等时即符合条件
    *
    *
    * */


    @Test
    void test(){
        Assertions.assertEquals(minWindow("ADOBECODEBANC" , "ABC") , "BANC");
        Assertions.assertEquals(minWindow("a" , "a") , "a");
        Assertions.assertEquals(minWindow("a" , "aa") , "");
        Assertions.assertEquals(minWindow("aaaaaaaaaaaabbbbbcdd" , "abcdd") , "abbbbbcdd");
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character , Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c , need.getOrDefault(c , 0) + 1);

        Map<Character , Integer> win = new HashMap<>();
        int l = 0 , r = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0; //
        int count = 0; // 两个map中相等元素的个数
        while (r < s.length()){

            char c = s.charAt(r);

            // 如果need中需要这个元素，则加入到win中统计
            if (need.containsKey(c)){
                win.put(c , win.getOrDefault(c , 0) + 1);
                if (win.get(c).equals(need.get(c))) count++;
            }

            // 满足条件
            while (count == need.size()){
                // 更新res
                if (r - l + 1  < minLen){
                    minLen = r - l + 1 ;
                    start = l;
                }
                // 左指针移动
                char b = s.charAt(l++);
                if (need.containsKey(b)){
                    win.put(b , win.getOrDefault(b , 0) - 1);
                    if (win.get(b) < need.get(b)) count--;
                }
            }

            // 右窗口滑动
            r++;
        }

       // System.out.println("start " + start +  " minLen = " + minLen);

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start , start + minLen);
    }


}
