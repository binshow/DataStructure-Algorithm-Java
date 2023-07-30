package dp.bag_01;

import java.util.Arrays;

public class _377组合总和 {

    //输入：nums = [1,2,3], target = 4
    //输出：7
    //解释：
    //所有可能的组合为：
    //(1, 1, 1, 1)
    //(1, 1, 2)
    //(1, 2, 1)
    //(1, 3)
    //(2, 1, 1)
    //(2, 2)
    //(3, 1)
    //请注意，顺序不同的序列被视作不同的组合。
    //

    public int combinationSum4(int[] nums, int target) {


        int n = nums.length;
        // dp[i] 表示 总和为i的组合个数
        int[] dp = new int[target+1];

        // dp[i] = dp[i-nums[0]] + dp[i-nums[1]] + ...
        // 比如说 134 组合成7  dp[7] = 1和dp[6] + 3和dp[4] + 4和dp[3]

        dp[0] = 1;
        for(int i = 1; i <= target ; i++){
            for(int num : nums){
                if( i >= num) dp[i] += dp[i-num];
            }
        }
        return dp[target];

    }
}
