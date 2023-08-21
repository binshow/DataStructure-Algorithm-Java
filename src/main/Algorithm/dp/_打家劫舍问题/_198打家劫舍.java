package Algorithm.dp._打家劫舍问题;

public class _198打家劫舍 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Algorithm.dp[i] 偷到 [0-i] 的最大值
        int[] dp = new int[n];

        // base condition
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        // Algorithm.dp transfer
        for(int i = 2 ; i < n ; i++){
            // 偷当前的 , 不偷当前的
            dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
        }
        //System.out.println(Arrays.toString(Algorithm.dp));
        return dp[n-1];

    }


    // 优化一些，将数组舍弃
    public int robV2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Algorithm.dp[i] 偷到 [0-i] 的最大值
        int[] dp = new int[n];

        // base condition
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        // Algorithm.dp transfer
        for(int i = 2 ; i < n ; i++){
            // 偷当前的 , 不偷当前的
            dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
        }
        //System.out.println(Arrays.toString(Algorithm.dp));
        return dp[n-1];

    }
}
