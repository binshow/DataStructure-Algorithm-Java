package dp.matrix_path;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/minimum-path-sum/
 * @date 2022/7/1011:12 AM
 */
public class min_path_sum {


    //Input: grid = [[1,3,1],[1,5,1],[4,2,1]]

    // 1 3 1
    // 1 5 1
    // 4 2 1

    //Output: 7
    //Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int i = 1; i < n; i++) dp[0][i] = dp[0][i-1] + grid[0][i];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

}
