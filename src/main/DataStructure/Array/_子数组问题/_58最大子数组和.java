package DataStructure.Array._子数组问题;


// https://leetcode.cn/problems/maximum-subarray/

public class _58最大子数组和 {



    // dp 解法
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;

        // dp[i]: 以nums[i] 结尾的连续子数组的最大和
        // 递归：dp[i+1] = Math.max(dp[i] , 0) + nums[i+1]
        int[] dp = new int[n];

        // base case
        dp[0] = nums[0];

        int res = dp[0];  // 结果就是 dp 数组中的最大值
        for(int i = 1 ; i < n ; i++) {
            dp[i] = Math.max(dp[i-1] , 0) + nums[i];
            res = Math.max(res , dp[i]);
        }
        return res;
    }


    // dp[i] 只与 dp[i-1] 相关，因此可以进行空间优化
    public int maxSubArrayV2(int[] nums) {
        if (nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums){
            if (sum > 0) sum += num;
            else sum = num;

            res = Math.max(res , sum);
        }
        return res;

    }


}
