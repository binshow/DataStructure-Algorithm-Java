package string;

import java.util.Arrays;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/longest-increasing-subsequence/
 * @date 2022/6/114:50 PM
 */
public class Longest_Increasing_Subsequence {

    // 找到数组中的最长递增子序列

    // 解法1：普通 Algorithm.dp，时间复杂度 n2
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // Algorithm.dp[i] 表示 以nums[i] 结尾的数组的最长递增子序列长度
        int[] dp = new int[n];
        Arrays.fill(dp , 1);

        for (int i = 1; i < n; i++) {
            for (int j = i-1 ; j >= 0 ; j--){
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
        }
        // 找到dp数组的最大值
        int res = 1;
        for (int num : dp) res = Math.max(res , num);
        return res;
    }

    // 解法2：二分，时间复杂度 O nlogn
    //比如序列是78912345，前三个遍历完以后dp是789，这时候遍历到1，就得把1放到合适的位置，于是在dp二分查找1的位置，变成了189（
    // 如果序列在此时结束，因为res不变，所以依旧输出3），
    // 再遍历到2成为129，然后是123直到12345
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        // Algorithm.dp[i] 保存的是每个子序列的最后一个数
        int[] dp = new int[n];
        int res = 0;
        for (int num : nums){
            // 找出当前数应该在 Algorithm.dp 中插入的位置，dp本身肯定是一个递增的数组
            int l = 0 , r = res;
            while (l < r) {
                int mid = l + r >> 1;
                if (dp[mid] < num) l = mid + 1;
                else r = mid;
            }
            dp[l] = num;
            if (res == l) res++;
        }
        return res;

    }


}
