package DataStructure.Array._子序列问题;

import java.util.Arrays;

public class _300最长递增子序列 {

    // https://leetcode.cn/problems/longest-increasing-subsequence/
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        int[] dp = new int[n];
        Arrays.fill(dp , 1);

        int res = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = i-1 ; j >= 0 ; j--){
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i] , dp[j] + 1);
            }

            res = Math.max(res , dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
