package Array;

import static Array.Partition_to_K_Equal_Sum_Subsets.canPartitionKSubsets;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/matchsticks-to-square/
 * https://leetcode.cn/problems/matchsticks-to-square/solution/by-lfool-iqvw/
 * @date 2022/6/110:50 PM
 */
public class Matchsticks_to_Square {

    // 数组能不能4等分？
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        return canPartitionKSubsets(nums, 4 );
    }


}
