package DataStructure.String._字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _438找到字符串中所有的字母异位词 {

    // https://leetcode.cn/problems/find-all-anagrams-in-a-string/


    // s 中包含了p的所有字母
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character , Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) need.put(c , need.getOrDefault(c , 0) +  1);

        List<Integer> res = new ArrayList<>();
        Map<Character , Integer> map = new HashMap<>();
        int l = 0 , r = 0;
        int count = 0;
        while (r < s.length()){
            char a = s.charAt(r);
            r++;
            if (need.containsKey(a)){
                map.put(a , map.getOrDefault(a , 0) + 1);
                if (map.get(a).equals(need.get(a))) count++;
            }

            while (count == need.size()){
                // 加入结果集
                if (r - l  == p.length())  res.add(l);

                char b = s.charAt(l);
                if (need.containsKey(b)){
                    map.put(b , map.getOrDefault(b , 0) - 1);
                    if (map.get(b) < need.get(b)) count--;
                }
                l++;
            }
        }
        return res;
    }
}
