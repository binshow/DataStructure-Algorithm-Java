package Algorithm.slide_windows;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// https://leetcode.cn/problems/repeated-dna-sequences/description/
public class _187_重复的DNA序列 {

    //DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
    //
    //例如，"ACGAATTCCG" 是一个 DNA序列 。
    //在研究 DNA 时，识别 DNA 中的重复序列非常有用。
    //
    //给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    //输出：["AAAAACCCCC","CCCCCAAAAA"]
    //示例 2：
    //
    //输入：s = "AAAAAAAAAAAAA"
    //输出：["AAAAAAAAAA"]


    @Test
    void test(){
        Assertions.assertEquals(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toString() , "[AAAAACCCCC, CCCCCAAAAA]");
        Assertions.assertEquals(findRepeatedDnaSequences("AAAAAAAAAAAAA").toString() , "[AAAAAAAAAA]");
    }



    /*
    * 思路： 固定大小的子串，用一个set记录出现过的10的子字符串，当第二次窗口内的子串在set中出现过时，即可加入结果集
    * */

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0 , j = 10; j < s.length() + 1; i++ , j++) {
            String cur = s.substring(i , j);
            //System.out.println(cur);
            if (set.contains(cur)) res.add(cur);
            set.add(cur);
        }
        return new ArrayList<>(res);
    }


}
