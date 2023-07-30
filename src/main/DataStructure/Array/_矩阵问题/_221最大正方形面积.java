package DataStructure.Array._矩阵问题;

public class _221最大正方形面积 {

    // https://leetcode.cn/problems/maximal-square/

    // 断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三个点也一定是某个正方形的右下角，
    // 否则该点为右下角的正方形最大就是它自己了。
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];
        int res = 1;

        for(int i = 1 ; i <= m ; i++){
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1] , dp[i-1][j]) , dp[i][j-1]) + 1;
                    res = Math.max(res , dp[i][j]);
                }
            }
        }
        return res *  res;
    }

}
