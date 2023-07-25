package dp.bag_01;

import java.util.Arrays;

public class _518零钱兑换v2 {

    // https://leetcode.cn/problems/coin-change-ii/
    public int change(int amount, int[] coins) {
        int n = coins.length;

        //1. dp[i] 表示 凑出金额 i的组合数
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

        return dp[amount];
    }

}
