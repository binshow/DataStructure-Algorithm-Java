package Algorithm.dp.bag_01;


import java.util.ArrayList;
import java.util.List;

public class _416分割等和子集 {
    //https://leetcode.cn/problems/partition-equal-subset-sum/

    // 01背包问题，dp解法
    // 给定一个数组和一个容量为x的背包，求有多少种方式让背包装满（有多少种子集能让子集之和等于背包容量）?
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;

        sum = sum / 2;
        int n = nums.length;

        // Algorithm.dp[i][j] : 表示前i个数任取能否组成j
        boolean[][] dp = new boolean[n+1][sum+1];

        // 不放物品i Algorithm.dp[i-1][j]
        // 放物品i   Algorithm.dp[i-1][j-nums[i]] + nums[i]
        // 两个状态只要有一个满足即可
        // 如果是求最大值，就取max即可


        // base case
        for(int i = 0 ; i <= n ; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i-1] > j) dp[i][j] = dp[i-1][j]; // 只能不取
                else dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];  // 取或者不取
            }
        }

        return dp[n][sum];

    }







    // Algorithm.dfs 解法: 超时
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums , 0 , sum / 2 , list , res);
        System.out.println(res);
        return res.size() > 1;
    }

    private void dfs(int[] nums, int start, int target, List<Integer> list , List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums , i+1 , target - nums[i] , list , res);
            list.remove(list.size()-1);
        }
    }

}
