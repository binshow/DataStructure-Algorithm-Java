package Algorithm.dp;


// https://leetcode.cn/problems/longest-palindromic-substring/
public class _05最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();

        // Algorithm.dp[i][j] : s[i-j]是不是回文子串
        boolean[][] dp = new boolean[n][n];

        for(int i = 0 ; i < n ; i++) dp[i][i] = true;

        int len = 1;
        int start = 0;

        // i 在前，j在后
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
               if (s.charAt(i) != s.charAt(j)) dp[i][j] = false;
               else {
                   if (j - i + 1 <= 2) dp[i][j] = true; // 两个元素肯定是回文
                   else dp[i][j] = dp[i+1][j-1];
               }

               if (dp[i][j] && j - i + 1 > len){
                   len = j - i + 1;
                   start = i;
               }
            }
        }

        return s.substring(start , start + len);

    }


}
