package DataStructure.Array.sub_sequence;

import java.util.Arrays;

public class _300最长递增子序列 {

    // https://leetcode.cn/problems/longest-increasing-subsequence/
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);

        for(int i = 1 ; i < n ; i++){
            for (int j = i-1; j >= 0 ; j--) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[j]+1 , dp[i]);
            }
        }
        //System.out.println(Arrays.toString(Algorithm.dp));

        int res = dp[0];
        for(int num : dp) res = Math.max(res , num);
        return res;
    }

}
