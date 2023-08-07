package DataStructure.String._字母异位词;

import java.util.*;

public class _49字母异位词分组 {

    // https://leetcode.cn/problems/group-anagrams/

    // 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    //

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String , List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String tem = new String(chars);
            if (map.containsKey(tem)) map.get(tem).add(s);
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(tem , list);
            }
        }

        for (String key : map.keySet()) res.add(map.get(key));
        return res;
    }
}
