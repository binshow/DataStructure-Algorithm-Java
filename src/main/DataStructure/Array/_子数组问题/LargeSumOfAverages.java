package DataStructure.Array._子数组问题;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/11/281:17 PM
 */
public class LargeSumOfAverages {

    //https://leetcode.cn/problems/largest-sum-of-averages/description/?languageTags=java

    // 最大平均值和的分组
    //输入: nums = [9,1,2,3,9], K = 3
    //输出: 20.00000
    //解释:
    //nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
    //我们也可以把 nums 分成[9, 1], [2], [3, 9].
    //这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
    public double largestSumOfAverages(int[] nums, int K) {
        // dp[i][K]: 将nums中的前i个数分成k个子数组的最大平均值和
        // K = 1 , dp[i][1] = (nums[0] + nums[1] +... + nums[i-1]) / i;
        // K > 1 , dp[i][K] = max(dp[j][K-1] + arg[j][i])
        // 其中j是[0,i-1]之间， avg[j][i] 是区间 [j ,i-1] 的平均值
        // avg[j][i] = (nums[j] + ... + nums[i-1]) / (i-j); 这一步可以使用前缀和来优化

        int n = nums.length;
        double[] sum = new double[n+1];
        for(int i = 1;  i <= n ; i++) sum[i] = sum[i-1] + nums[i-1];

        // dp[i][K] : 将nums中的前i个数分成k个子数组的最大平均值总和
        double[][] dp = new double[n+1][K+1];

        // base case: K=1 只能分一组
        for(int i = 1 ; i <= n ; i++) dp[i][1] = sum[i] / i;

        // 开始dp
        for (int i = 1;  i <= n ; i++){
            for (int k = 2 ; k <= K ; k++) {
                for (int j = 1;  j < i ; j++) {
                    double avg = (sum[i] - sum[j]) / (i-j);
                    //取较大值
                    dp[i][k] = Math.max(dp[i][k] , dp[j][k-1] + avg);
                }
            }
        }
        return dp[n][K];
    }

    //https://leetcode.cn/problems/largest-sum-of-averages/solutions/498988/java-cong-di-gui-dao-ji-yi-hua-di-gui-dao-dp-by-pp/?languageTags=java
    //https://leetcode.cn/problems/largest-sum-of-averages/solutions/1995139/by-ac_oier-yfnt/


}
