package Algorithm.dp.bag_01;

import java.util.Arrays;

public class _322零钱兑换 {

    // https://leetcode.cn/problems/coin-change/
    // 求最小的钱币数量
    public int coinChange(int[] coins, int amount) {
        // Algorithm.dp[i] = 凑出金额 i 的最小硬币数
        int[] dp = new int[amount+1];

        Arrays.fill(dp , amount + 1);
        dp[0] = 0;
        // 先遍历物品
        for(int num : coins){
            for(int i = 1 ; i <= amount ; i++){
                if(i >= num) dp[i] = Math.min(dp[i] , dp[i-num] + 1);
            }
        }

        return dp[amount] == amount + 1 ? - 1 : dp[amount];


    }




}
