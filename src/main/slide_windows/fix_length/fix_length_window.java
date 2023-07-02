package slide_windows.fix_length;

import java.util.*;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/3/38:33 PM
 */
public class fix_length_window {





    //https://leetcode.cn/problems/permutation-in-string/
    //输入：s1 = "ab" s2 = "eidbaooo"
    //输出：true
    //解释：s2 包含 s1 的排列之一 ("ba").
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        for(char c : s1.toCharArray()) need[c-'a']++;
        // 固定滑动窗口，注意小于等于！
        for (int i = 0; i + s1.length() <= s2.length(); i++) {
            String tem = s2.substring(i , i + s1.length());
            if (checkHelp(need , tem)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHelp(int[] need, String tem) {
        int[] nums = new int[26];
        for(char c : tem.toCharArray()) nums[c-'a']++;
        for(int i = 0 ; i < 26 ; i++){
            if (need[i] != nums[i]) return false;
        }
        return true;
    }

    public static boolean checkInclusionV2(String s1, String s2){
        Map<Character , Integer> need = new HashMap<>();
        for(char c : s1.toCharArray()) need.put(c , need.getOrDefault(c , 0) + 1);
        System.out.println(need);
        Map<Character , Integer> win = new HashMap<>();
        int valid = 0;
        int l = 0;
        for (int i = 0; i < s2.length(); i++) {
            char a  = s2.charAt(i);
            if (need.containsKey(a)){
                win.put(a , win.getOrDefault(a , 0) + 1);
                if (win.get(a).equals(need.get(a))) valid++;
            }
            while (valid == need.size()){
//                System.out.println(win);
//                System.out.println(s2.substring(l , i + 1));
                if (i - l + 1 == s1.length()) return true;
                char b = s2.charAt(l);
                if (need.containsKey(b)){
                    win.put(b , win.getOrDefault(b , 0) - 1);
                    if (win.get(b) < need.get(b) ) valid--;
                }
                l++;
            }
        }
        return false;
    }




    //https://leetcode.cn/problems/find-all-anagrams-in-a-string/
    //输入: s = "cbaebabacd", p = "abc"
    //输出: [0,6]
    //解释:
    //起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    //起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character , Integer> need = new HashMap<>();
        Map<Character , Integer> win = new HashMap<>();
        for (char c : p.toCharArray()) need.put(c , need.getOrDefault(c ,0) + 1);
        int valid = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (need.containsKey(a)){
                win.put(a , win.getOrDefault(a , 0 ) + 1);
                if (win.get(a).equals(need.get(a))) valid++;
            }

            while (valid == need.size()){
                // 加入结果
                if (i - l + 1 == p.length()){
                    res.add(l);
                }
                char b = s.charAt(l);
                if (need.containsKey(b)){
                    win.put(b , win.getOrDefault(b , 0)-1);
                    if (win.get(b) < need.get(b)) valid--;
                }
                l++;
            }
        }
        return res;
    }





    public static void main(String[] args) {
//        List<Integer> res = findAnagrams("cbaebabacd", "abc");
//        System.out.println(res.toString());

        System.out.println(checkInclusionV2("ab", "eidbaooo"));

    }


}
