package Algorithm.dp.bag_01;

// https://leetcode.cn/problems/target-sum/
public class _494目标和 {

    // 题解：https://leetcode.cn/problems/target-sum/solution/yi-wen-jiang-tou-you-yi-dao-nan-yi-bu-bu-fjsz/


    // 方法1：穷举
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums , 0 , target);
        return res;
    }

    private void dfs(int[] nums, int start, int target) {
        if (start == nums.length ){
            if (target == 0)  res++;
            return;
        }
        dfs(nums , start + 1 , target - nums[start]);
        dfs(nums , start + 1 , target + nums[start]);
    }


    // 方法2： 假设数组中的正数和为 p ， 负数和为 n , 则：
    // sum = p + n
    // target = p - n
    // target = p - (sum - p) = 2p - sum
    // p = (target + sum) / 2
    // 也就是说数组中找到一些 数字，其和为 target + sum

    // Algorithm.dfs
    public int findTargetSumWaysV2(int[] nums, int target) {
        int sum = target;
        for(int num : nums) sum += num;
        if (sum % 2 == 1) return 0; // 是奇数，无解
        return dfsv2(nums , 0 , sum / 2);
    }

    private int dfsv2(int[] nums, int start, int target) {
        if (start == nums.length){
            if (target == 0) return 1;
            else return 0;
        }
        // 不选 + 选
        return dfsv2(nums , start+1 , target) + dfsv2(nums ,start+1 , target - nums[start]);
    }



    // 方法3：Algorithm.dp 变成背包问题
    public int findTargetSumWaysV3(int[] nums, int target) {
        int sum = target;
        for(int num : nums) sum += num;
        if (sum % 2 == 1) return 0; // 是奇数，无解
        target = sum / 2;
        if(target < 0) return 0;  // 负数排除

        // 问题转换成，从 nums 中取一些元素，和为 target的种类
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int num : nums){
            for (int i = target; i >= num; i--){
                dp[i] += dp[i - num];
            }
        }
        //System.out.println(Arrays.toString(Algorithm.dp));
        return dp[target];
    }


}
