package dp.matrix_path;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/cherry-pickup/
 * @date 2022/7/1011:24 AM
 */
public class cherry_pick_up {


    // 原问题等价于2个点同时从左上到右下的取值最大
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        // dp[k][i1][i2] 表示当前走了k步，且第一个点在 i1行，第二个点在 i2行时的最大得分
        // 最终答案为 dp[2n][n][n] , 初始状态为 f[2][1][1] = g[0][0] 的状态
        int[][][] dp = new int[n * 2 + 1][n+1][n+1];
        
        // 初始化赋值
        for (int k = 0; k <= 2 * n; k++) {
            for (int i1 = 0; i1 <= n; i1++) {
                for (int i2 = 0; i2 <= n; i2++) {
                    dp[k][i1][i2] = Integer.MIN_VALUE;
                }
            }
        }

        dp[2][1][1] = grid[0][0];
        // 状态转移
        for (int k = 3; k <= 2 * n; k++) {
            for (int i1 = 1; i1 <= n ; i1++) {
                for (int i2 = 1; i2 <= n ; i2++) {
                    int j1 = k - i1 , j2 = k - i2;
                    if (j1 <= 0 || j1 > n || j2 <= 0 || j2 > n) continue; // 越界了
                    int A = grid[i1-1][j1-1] , B = grid[i2-1][j2-1];
                    if (A == -1 || B == -1) continue; // 阻塞了

                    // 4 中前置状态
                    int a = dp[k - 1][i1 - 1][i2], b = dp[k - 1][i1 - 1][i2 - 1], c = dp[k - 1][i1][i2 - 1], d = dp[k - 1][i1][i2];
                    int t = Math.max(Math.max(a, b), Math.max(c, d)) + A;
                    if (i1 != i2) t += B;
                    dp[k][i1][i2] = t;

                }
            }
        }
        return Math.max(dp[2 * n][n][n], 0);
    }
}
