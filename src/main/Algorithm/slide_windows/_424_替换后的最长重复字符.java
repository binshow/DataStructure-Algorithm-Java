package Algorithm.slide_windows;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/longest-repeating-character-replacement/description/
public class _424_替换后的最长重复字符 {


    //给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
    //在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "ABAB", k = 2
    //输出：4
    //解释：用两个'A'替换为两个'B',反之亦然。
    //示例 2：
    //
    //输入：s = "AABABBA", k = 1
    //输出：4
    //解释：
    //将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
    //子串 "BBBB" 有最长重复字母, 答案为 4。
    //可能存在其他的方法来得到同样的结果。





    /*
    * 思路： 最长子串
    *
    *       对于合法的子串而言，必然有 sum(所有字符的出现次数) - max(出现次数最多的字符的出现次数）= other(其他字符的出现次数) <= k
    *
    *       窗口的大小与新字符的最大计数之间的差值表示可以替换的字符个数，当可以替换的字符个数大于 k 时，我们需要缩小窗口，也就是 left 右移，直到可以替换的字符个数等于 k 时，我们可以得到结果 !!!
    * */

    public int characterReplacement(String s, int k) {
            int n = s.length();
            Map<Character , Integer> map = new HashMap<>();
            int l = 0 , r = 0;
            int res = 0;
            while (r < n){
                char c = s.charAt(r);
                map.put(c , map.getOrDefault(c , 0) + 1);

                while (!check(map , k)){
                    // 窗口内不满足条件, 左指针移动
                    char b = s.charAt(l);
                    map.put(b , map.getOrDefault(b , 0) - 1);
                    l++;
                }
                res = Math.max(res , r - l + 1); // 满足条件了
                r++;
            }
            return res;
    }

    private boolean check(Map<Character, Integer> map, int k) {
        int sum = 0 , max = 0;
        for (char c : map.keySet()){
            sum += map.get(c);
            max = Math.max(max , map.get(c));
        }
        return sum - max <= k;
    }


    // todo check 函数可以进行优化一下：

    //class Solution {
    //    public int characterReplacement(String s, int k) {
    //
    //        int n = s.length();
    //        int l = 0;
    //        int cnt = 0; // 窗口内最多出现的重复字符数量
    //        int res = 0;
    //        Map<Character , Integer> map = new HashMap<>();
    //        for(int r = 0 ; r < n ; r++){
    //            char c = s.charAt(r);
    //            map.put(c , map.getOrDefault(c , 0) + 1);
    //            cnt = Math.max(cnt , map.get(c));
    //
    //            // 窗口大小 - 最多重复字符数量 > k 说明不可以执行 k 次达到全部是重复字符
    //            // while 不满足条件
    //            while( r - l + 1  - cnt  > k ){
    //                map.put(s.charAt(l) , map.getOrDefault(s.charAt(l) , 0) - 1);
    //                l++;
    //            }
    //            res = Math.max(res , r - l + 1);
    //            //System.out.println("l : " + l + ", r : " + r);
    //        }
    //        return res;
    //
    //    }
    //}

}
