package dp._打家劫舍问题;

public class _1388_3n块披萨 {

    // 1. 首尾不能同时选
    // 2. 不能相邻选

    // 注意和 打家劫舍2 的区别
    public int maxSizeSlices(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0] , nums[1]);

        int n = nums.length;
        int k = n / 3;
        // 要么拿第一个，要么拿第二个
        return Math.max(getRangeMax(nums , 0 , n - 2 , k) , getRangeMax(nums , 1 , n - 1 , k));
    }


    int getRangeMax(int[] nums , int l , int r , int k){
        if(l == r) return nums[l];
        int length = r - l + 1;
        // dp[i][j] = the max size we can get, range: [0, i], picked count: j
        int[][] dp = new int[length][k+1];

        // base condition
        dp[0][0] = 0;
        dp[0][1] = nums[l];
        dp[1][0] = 0;
        dp[1][1] = Math.max(nums[l], nums[l+1]);

        // dp transfer
        for (int i = 2; i < length; i++) {
            for (int j = 1; j <= k; j++) {
                // 拿当前值 ， 不拿当前值
                dp[i][j] = Math.max(dp[i-2][j-1] + nums[l + i] , dp[i-1][j]);
            }
        }

        return dp[length-1][k];
    }
}
