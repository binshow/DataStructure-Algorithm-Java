package string;

import java.util.*;

// https://leetcode.cn/problems/group-anagrams/
public class _49字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String , List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) map.get(key).add(s);
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key , list);
            }
        }

        for (String key : map.keySet()) res.add(map.get(key));
        return res;
    }


}
