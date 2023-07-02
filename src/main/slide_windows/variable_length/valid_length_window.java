package slide_windows.variable_length;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: 可变大小的滑动窗口
 * @date 2023/3/39:16 PM
 */
public class valid_length_window {

    //https://leetcode.cn/problems/minimum-window-substring/
    //输入：s = "ADOBECODEBANC", t = "ABC"
    //输出："BANC"
    //解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
    public String minWindow(String s, String t) {
        Map<Character , Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c  , need.getOrDefault(c , 0) + 1);

        Map<Character , Integer> win = new HashMap<>();
        int valid = 0;
        int l = 0;
        int start = 0 , len = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (need.containsKey(a)){
                win.put(a , win.getOrDefault(a , 0 ) + 1);
                if (win.get(a).equals( need.get(a))) valid++;
            }
            // 注意这个 while ，保存的是 左指针往右滑动的条件！！！
            while (valid == need.size()){
                if (i - l + 1 < len){
                    len = i - l + 1;
                    start = l;
                }
                char b = s.charAt(l);
                if (need.containsKey(b)){
                    win.put(b , win.getOrDefault(b , 0) - 1);
                    if (win.get(b) < need.get(b)) valid--;
                }
                l++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start , start + len);

    }



    //https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/
    // 输入："eceba"
    // 输出：3 子串 ece
    // 求最长子串长度， 要求这个子串里面只有两个不同的字母
    public static int lengthOfLongestSubstringTwoDistinct(String s){
        if (s.length() == 0) return  0;
        Map<Character , Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char a  = s.charAt(i);
            map.put(a , map.getOrDefault(a , 0) + 1);
            while (map.size() > 2){
                char b = s.charAt(l);
                map.put(b , map.get(b) - 1);
                if (map.get(b) == 0) map.remove(b);
                l++;
            }
            // 现在map 复合条件了
            if (i - l + 1 > res){
                res = i - l + 1;
                start = l;
                System.out.println(s.substring(start , start + res));
            }
        }
        return res;
    }


    //https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/
    // k个不同的字母


    //https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
    public static int longestSubstring(String s, int k) {
        int res = 0;
        // unique 表示有出现k次的字符
        for (int unique = 1; unique <= 26; unique++) {
            Map<Character , Integer> map = new HashMap<>();
            int l = 0 , valid = 0;
            for (int i = 0; i < s.length(); i++) {
                char a  = s.charAt(i);
                map.put(a , map.getOrDefault(a , 0) + 1);
                if (map.get(a) == k) valid++;

                while (map.keySet().size() > unique){
                    char b = s.charAt(l);
                    if (map.get(b) == k) valid--;
                    map.put(b , map.getOrDefault(b , 0) - 1);
                    if (map.get(b) == 0) map.remove(b);
                    l++;
                }
                // 满足条件：map.keySet().size() == unique
                if (map.keySet().size() == valid ) res = Math.max(res , i - l + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceeecba"));

        System.out.println(longestSubstring("bbaaacbd", 3));
    }





}
