package string.subsequences;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/distinct-subsequences-ii/
 * @date 2022/6/1010:09 AM
 */
public class Distinct_Subsequences_II {

    // 不同的子序列个数
    //Input: s = "abc"
    //Output: 7
    //Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc"

    // 以字符串 "abac" 为例
    // 第一个字符 a : dp[a] = 0 + 1   = 1        // 即是a本身
    // 第二个字符 b : dp[b] = 1 + 1   = 2        // 即是 ab + b本身
    // 第三个字符 a : dp[a] = 1 + 2 + 1  = 4     // 即是 aa aba ba + a 本身
    // 第四个字符 a : dp[c] = 4 + 2 + 1  = 7     // 即是 aac + abac + abc + bac + ac + bc + c
    // 综上： dp[a] + dp[b] + dp[c] = 4 + 2 + 7 = 13
    // 可推广到 26 个英文字母
    public int distinctSubseqII(String s) {
        return 0;
    }

}
