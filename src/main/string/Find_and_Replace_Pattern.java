package string;

import java.util.*;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/find-and-replace-pattern/
 * @date 2022/6/1211:06 AM
 */

// 类似题：205 、 290
public class Find_and_Replace_Pattern {

    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(words, pattern));
    }


    //Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
    //Output: ["mee","aqq"]
    //Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
    //"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
    //
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String s : words){
            if (isValid(s , pattern)) res.add(s);
        }
        return res;
    }

    // 判断 s 和 pattern 之间是否有映射关系
    private static boolean isValid(String s, String pattern) {
        if (s.length() != pattern.length()) return false;
        Map<Character , Character> map = new HashMap<>();
        char[] ns = s.toCharArray();
        char[] ps = pattern.toCharArray();
        for (int i = 0 ; i < ns.length ; i++){
            if (map.containsKey(ps[i]) && map.get(ps[i]) != ns[i]) return false;
            else{
                map.put(ps[i] , ns[i]);
            }
        }
        // 这个 map 中不同的 key 不能包含相同点 value
        Set<Character> set = new HashSet<>();
        for (Character value : map.values()){
            if (!set.add(value)) return false;
        }
        return true;
    }

}
