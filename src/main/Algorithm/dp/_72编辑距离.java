package Algorithm.dp;

// https://leetcode.cn/problems/edit-distance/
public class _72编辑距离 {


    public int minDistance(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        if (ls == 0) return lp;
        if (lp == 0) return ls;

        int[][] dp = new int[ls+1][lp+1];
        for(int i = 0 ; i <= ls ; i++) dp[i][0] = i;
        for(int i = 0 ; i <= lp ; i++) dp[0][i] = i;

        for(int i = 1 ; i <= ls ; i++){
            for(int j = 1 ; j <= lp ; j++){
                if (s.charAt(i-1) == p.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(Math.min(dp[i-1][j] , dp[i][j-1]) , dp[i-1][j-1]) + 1;
            }
        }

        return dp[ls][lp];
    }
}
