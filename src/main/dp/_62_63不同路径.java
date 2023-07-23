package dp;

public class _62_63不同路径 {

    // https://leetcode.cn/problems/unique-paths/
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 1;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++) dp[i][0] = 1;
        for(int i = 0 ; i < n ; i++) dp[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    // https://leetcode.cn/problems/unique-paths-ii/
    public int uniquePathsWithObstacles(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (n == 0) return 1;

        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            if (board[i][0] == 1) {
                dp[i][0] = 0;
                break;
            }
            dp[i][0] = 1;
        }

        for(int i = 0 ; i < n ; i++){
            if (board[0][i] == 1) {
                dp[0][i] = 0;
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
