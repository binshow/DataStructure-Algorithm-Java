package dp.bag_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _322零钱兑换 {

    // https://leetcode.cn/problems/coin-change/
    // 求最小的钱币数量
    public int coinChange(int[] coins, int amount) {
        // dp[i] = 凑出金额 i 的最小硬币数
        int[] dp = new int[amount+1];
        Arrays.fill(dp , amount+1);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {  // 先遍历背包
            for(int coin : coins){          // 再遍历物品
                if (i > coin) dp[i] = Math.min(dp[i] , dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];


    }




}
