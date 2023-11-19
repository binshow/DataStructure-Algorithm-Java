package Algorithm.slide_windows;


// https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class _395_至少有K个重复字符的子串 {

    //给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
    //
    //如果不存在这样的子字符串，则返回 0。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "aaabb", k = 3
    //输出：3
    //解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
    //示例 2：
    //
    //输入：s = "ababbc", k = 2
    //输出：5
    //解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。




    @Test
    void test(){
        Assertions.assertEquals(longestSubstring("aaabb" , 3) , 3);
        Assertions.assertEquals(longestSubstring("ababbc" , 2) , 5);
    }




    // 思路：分治的思想：当字符串中的某个字符出现次数小于k， 那么答案必不可能 包含这个字符!!!
    // 因此可以基于这个字符 进行分割，递归调用自身函数
    // 递归截止条件：s 的长度小于 k ， 说明根本不存在，直接返回 0

    public int longestSubstringV2(String s, int k) {
        if (s.length() < k) return 0;

        Map<Character , Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c , map.getOrDefault(c , 0) + 1);
        for (char c : map.keySet()){
            if (map.get(c) < k){
                int res = 0;
                for (String tmp : s.split(String.valueOf(c))){
                    res = Math.max(res , longestSubstringV2(tmp , k));
                }
                return res;
            }
        }
        // 说明都满足
        return s.length();
    }





    // 思路：最长、最短子串问题，但本题 不满足单调性， [i , j] 之前满足条件， 因此不能直接用滑动窗口
    //   窗口内每个字符出现次数都 >= k , 可以用一个 map 来记录次数

    public int longestSubstring(String s, int k) {

        int res = 0;
        int l = 0 , r = 0;
        Map<Character , Integer> map = new HashMap<>();

        while (r < s.length()){
            char a = s.charAt(r);
            map.put(a , map.getOrDefault(a , 0) + 1);
            while (check(map , k)){
                if (r - l + 1 > res){
                    res = r - l + 1;
                }

                char b = s.charAt(l++);
                map.put(b , map.getOrDefault(b , 0) - 1);
            }
            r++;
        }
        return res;
    }

    boolean check(Map<Character , Integer> map , int k){
        for (char key : map.keySet()){
            if (map.get(key) < k) return false;
        }
        return true;
    }

}
