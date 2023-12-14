package Algorithm.binarySearch;

import java.util.Arrays;

public class _300_最长递增子序列 {



    //https://leetcode.cn/problems/longest-increasing-subsequence/description/



    // https://leetcode.cn/problems/longest-increasing-subsequence/solutions/24173/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/


    // 最长递增子序列长度

    // 解法1：简单DP
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i] 表示 以 nums[i] 结尾的最长递增子序列
        int[] dp = new int[n];

        // base case
        Arrays.fill(dp , 1);

        int res = 1;
        // 状态递推
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
            res = Math.max(res , dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
