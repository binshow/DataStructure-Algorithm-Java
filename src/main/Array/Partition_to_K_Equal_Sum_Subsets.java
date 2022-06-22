package Array;

import java.util.Arrays;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 * @date 2022/6/111:12 PM
 */
public class Partition_to_K_Equal_Sum_Subsets {

    // 判断数组是否可以划分成K个相等的子集
    // 时间复杂度 k的n次方
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length  < k) return false;
        int sum = 0;
        for(int num : nums) sum += num;
        if (sum % k != 0) return false;

        int[] buckets = new int[k];
        return dfs(nums , 0 , buckets , k , sum / k);
    }

    // index : 第 index 个球开始做选择
    // bucket : 桶
    private static boolean dfs(int[] nums, int index, int[] buckets, int k , int target) {
        // 递归截止条件
        if (index == nums.length){
            // 判断每个桶中数的和是否满足条件
            for (int num : buckets){
                if (num != target) return false;
            }
            return true;
        }

        // nums[index] 开始做选择
        for (int i = 0 ; i < k ; i++){
            // 剪支：nums[index] 放在当前桶里，超过了target
            if (nums[index] + buckets[i] > target) continue;

            // 第二个优化点，很关键！！！
            // 如果当前桶和上一个桶内的元素和相等，则跳过
            // 原因：如果元素和相等，那么 nums[index] 选择上一个桶和选择当前桶可以得到的结果是一致的
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;

            // 做选择
            buckets[i] += nums[index];

            // 继续下一个桶,下一个桶也可以的话，就返回true
            if (dfs(nums , index +1  , buckets , k , target)) return true;

            // 回溯
            buckets[i] -= nums[index];
        }

        return false;
    }



}
