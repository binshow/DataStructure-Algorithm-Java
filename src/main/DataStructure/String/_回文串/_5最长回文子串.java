package DataStructure.String._回文串;

public class _5最长回文子串 {

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0 ; i < n ; i++) dp[i][i] = true;

        for(int i = n-2 ; i >= 0 ; i--){
            for(int j = i+1 ; j < n ; j++){
                if (s.charAt(i) != s.charAt(j)) dp[i][j] = false;
                else {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }

                if (dp[i][j] && j - i + 1> maxLen){
                    maxLen = j - i + 1 ;
                    start = i;
                }
            }
        }

        return s.substring(start , start + maxLen);

    }
}
