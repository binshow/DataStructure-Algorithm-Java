package Algorithm.dp.lcs;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/6/2710:26 PM
 */
public class longest_uncommon_subsequence_ii {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aabec";
        System.out.println(isSubstring(s1, s2));
    }

    //给出一个字符串数组，在里面找出字符串满足当前字符串不是字符串数组中其他字符串的子序列，返回满足条件的字符串中 最长的字符串的长度
    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubstring(strs[j], strs[i])) {
                    break;
                }
            }
            if (j == strs.length) {
                max = Math.max(strs[i].length(), max);
            }
        }
        return max;
    }
    public static boolean isSubstring(String s1, String s2) {
        int j = 0;
        for (int i = 0; i < s1.length() && j < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
        }
        return j == s2.length();
    }
}
