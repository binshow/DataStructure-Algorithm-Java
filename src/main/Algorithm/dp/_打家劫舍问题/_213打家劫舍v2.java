package Algorithm.dp._打家劫舍问题;

import java.util.Arrays;

public class _213打家劫舍v2 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0] , nums[1]);

        // Algorithm.dp[i] 偷到第i个时的最大值

        // 偷第一个
        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = nums[0];
        for(int i = 2 ; i < n-1 ; i++){
            dp1[i] = Math.max(dp1[i-1] , dp1[i-2] + nums[i]);
        }

        // 偷最后一个
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for(int i = 2; i < n ; i++){
            dp2[i] = Math.max(dp2[i-1] , dp2[i-2] + nums[i]);
        }

        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp2));

        // 取最后一个数的max
        return Math.max(dp1[n-2] , dp2[n-1]);

    }
}
