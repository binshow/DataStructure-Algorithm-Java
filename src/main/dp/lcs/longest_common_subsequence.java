package dp.lcs;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/longest-common-subsequence/
 * @date 2022/6/2710:01 PM
 */
public class longest_common_subsequence {

    // 求两个string的最长公共子序列
    public int longestCommonSubsequence(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        // dp[i][j] : s[0-i] 和 p[0-j] 之间的最长公共子序列
        int[][] dp = new int[ls+1][lp+1];
        dp[0][0] = 0;
        for (int i = 1; i <= ls; i++) {
            for (int j = 1; j <= lp; j++) {
                if (s.charAt(i-1) == p.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[ls][lp];
    }
}
