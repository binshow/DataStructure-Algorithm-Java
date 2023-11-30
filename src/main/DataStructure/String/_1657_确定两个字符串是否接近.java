package DataStructure.String;


import java.util.Arrays;

//https://leetcode.cn/problems/determine-if-two-strings-are-close/description/?envType=daily-question&envId=2023-11-30
public class _1657_确定两个字符串是否接近 {

    //如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
    //
    //操作 1：交换任意两个 现有 字符。
    //例如，abcde -> aecdb
    //操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
    //例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
    //你可以根据需要对任意一个字符串多次使用这两种操作。
    //
    //给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
    //
    //
    //
    //示例 1：
    //
    //输入：word1 = "abc", word2 = "bca"
    //输出：true
    //解释：2 次操作从 word1 获得 word2 。
    //执行操作 1："abc" -> "acb"
    //执行操作 1："acb" -> "bca"
    //示例 2：
    //
    //输入：word1 = "a", word2 = "aa"
    //输出：false
    //解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
    //示例 3：
    //
    //输入：word1 = "cabbba", word2 = "abbccc"
    //输出：true
    //解释：3 次操作从 word1 获得 word2 。
    //执行操作 1："cabbba" -> "caabbb"
    //执行操作 2："caabbb" -> "baaccc"
    //执行操作 2："baaccc" -> "abbccc"
    //示例 4：
    //
    //输入：word1 = "cabbba", word2 = "aabbss"
    //输出：false
    //解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。



    // 操作1：说明两个字符串  字符种类需要相同  （可以随意更改字符排序）
    // 操作2：说明两个字符串  字符频次需要相同  （可以随意更改字符频率）
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;


        int[] c1 = new int[26];
        for(char c : word1.toCharArray()) c1[c - 'a']++;

        int[] c2 = new int[26];
        for(char c : word2.toCharArray()) c2[c - 'a']++;

        // System.out.println(Arrays.toString(c1));
        // System.out.println(Arrays.toString(c2));

        //1. 两个字符串 所有字符都相同
        for(int i = 0 ; i < 26 ; i++){
            if(c1[i] == 0 && c2[i] == 0) continue;     // 两个都为0没问题
            if(c1[i] == 0 || c2[i] == 0) return false; // 仅在 s1 或 s2 中出现过
        }

        // 2. 统计频率是否相同
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i = 0;  i < 26 ; i++){
            if(c1[i] != c2[i]) return false;
        }

        return true;
    }
}
