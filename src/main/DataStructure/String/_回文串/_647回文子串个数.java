package DataStructure.String._回文串;


// https://leetcode.cn/problems/palindromic-substrings/

public class _647回文子串个数 {

    //输入：s = "aaa"
    //输出：6
    //解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0 ; i < n ; i++) dp[i][i] = true;

        for(int i = n-1 ; i >= 0 ; i--){
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) dp[i][j] = false;
                else {
                    if (i - j < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }

                if (dp[i][j]) res++;
            }
        }
        return res + n;

    }
}
