package dp;

import java.util.List;

// https://leetcode.cn/problems/triangle/
public class _120三角形最小路径和 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();

        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1 ; i < m ; i++){
            for (int j = 0; j <= i; j++) {
                if (j == 0) dp[i][0] = dp[i-1][j] +  triangle.get(i).get(j);
                else if (j == i) dp[i][j] = dp[i-1][j-1] +  triangle.get(i).get(j);
                else dp[i][j] = Math.min(dp[i-1][j] , dp[i-1][j-1]) + triangle.get(i).get(j);
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++) res = Math.min(res , dp[m-1][i]);
        return res;
    }
}
