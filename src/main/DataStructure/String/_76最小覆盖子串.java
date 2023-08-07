package DataStructure.String;

import java.util.HashMap;
import java.util.Map;

public class _76最小覆盖子串 {

    // https://leetcode.cn/problems/minimum-window-substring/

    public static String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length() ) return "";

        Map<Character , Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c , need.getOrDefault(c , 0) + 1);

        int l = 0, r = 0;
        int count = 0;
        int maxLen = Integer.MAX_VALUE, start = 0;
        int n = s.length();
        Map<Character , Integer> map = new HashMap<>();
        while (r < n){
            char c = s.charAt(r);
            r++;
            if (need.containsKey(c)){
                map.put(c , map.getOrDefault(c , 0) + 1);
                if (map.get(c).equals(need.get(c))) count++;
            }

            //System.out.println(count);

            while (count == need.size()){
                if (r - l < maxLen){
                    // System.out.println("l:" + l + ",r:" + r );
                    maxLen = r - l;
                    start = l;
                }

                char b = s.charAt(l);
                if (need.containsKey(b)){
                    map.put(b , map.getOrDefault(b , 0) - 1);
                    if (map.get(b) < need.get(b)) count--;
                }
                l++;

            }
        }

        return maxLen == Integer.MAX_VALUE ? "" : s.substring(start , start + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
