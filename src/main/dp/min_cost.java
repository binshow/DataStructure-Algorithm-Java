package dp;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/JEj789/
 * @date 2022/6/251:12 PM
 */
public class min_cost {

    //输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
    //输出: 10
    //解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
    // 最少花费: 2 + 5 + 3 = 10。
    public int minCost(int[][] costs) {
        // 只有三种颜色
        int n = costs.length; // n 个房子
        int[][] dp = new int[n+1][3];
        for (int i = 1; i <= n ; i++){
            dp[i][0] = Math.min(dp[i-1][1] , dp[i-1][2]) + costs[i-1][0];
            dp[i][1] = Math.min(dp[i-1][0] , dp[i-1][2]) + costs[i-1][1];
            dp[i][2] = Math.min(dp[i-1][0] , dp[i-1][1]) + costs[i-1][2];
        }
        return Math.min(Math.min(dp[n][0] , dp[n][1]) , dp[n][2]);

    }

}
