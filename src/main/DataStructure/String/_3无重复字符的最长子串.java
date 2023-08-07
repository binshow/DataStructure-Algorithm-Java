package DataStructure.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3无重复字符的最长子串 {

    //https://leetcode.cn/problems/longest-substring-without-repeating-characters/



    // 解法1： hashset

    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return n;

        Set<Character> set = new HashSet<>();
        int res = 1;
        for(int i = 0 , j = 0 ; i < n ; i++){
            while (set.contains(s.charAt(i))){
                set.remove(s.charAt(j++));
            }
            set.add(s.charAt(i));
            res = Math.max(res , i - j + 1);
        }

        return res;
    }


    // hashmap 加速
    public static int lengthOfLongestSubstringV2(String s) {
        int n = s.length();
        if (n == 0) return n;

        Map<Character , Integer> map = new HashMap<>();
        int res = 1;
        for(int i = 0  , j = 0 ; i < n ; i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j , map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i) , i);
            res = Math.max(res , i - j + 1);
           // System.out.println(s.substring(j , i+1));
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstringV2("abcabcbb"));

    }
}
