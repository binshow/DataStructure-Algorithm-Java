package Algorithm.dp.bag_01;

import java.util.Arrays;

public class _518零钱兑换v2 {

    // https://leetcode.cn/problems/coin-change-ii/

    public int change(int amount, int[] coins) {
        int n = coins.length;

        //1. Algorithm.dp[i] 表示 凑出金额 i的组合数
        int[][] dp = new int[n+1][amount+1];
        for (int i = 0 ; i <= n  ; i++) dp[i][0] = 1;

        for(int i = 1;  i <= n ; i++){
            for(int j = 1 ; j <= amount ; j++){
                if (j >= coins[i-1]) dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][amount];
    }

    public int changeV2(int amount, int[] coins) {
        int n = coins.length;

        //1. Algorithm.dp[i] 表示 凑出金额 i的组合数
        int[] dp = new int[amount+1];

        //2. base case
        dp[0] = 1;

        //3. 遍历所有的硬币
        for(int i = 0 ;i < n ;i++){
            for(int j = 1; j <= amount ; j++){
                //4. 说明可以用当前硬币凑金额
                if(coins[i] <= j) dp[j] += dp[j-coins[i]];
            }
        }

        for (int i = 0; i <= amount; i++) {
            for (int num : coins) {
                if (num <= i) dp[i] += dp[i-num];
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[amount];
    }

}
