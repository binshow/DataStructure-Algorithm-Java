package Algorithm.slide_windows.variable_length;


// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;
import java.util.Map;

public class _3无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character , Integer> map = new HashMap<>();
        int res = 1;

        for (int i = 0 , j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) ){
                j = Math.max(j , map.get(s.charAt(i)) + 1); // j只能往前走
            }
            if (i - j + 1 > res){
                res = i - j + 1;
                //System.out.println(s.substring(j , i+1));
            }
           // res = Math.max(res , i - j + 1);
            map.put(s.charAt(i) , i);
        }
        return res;
    }


}
