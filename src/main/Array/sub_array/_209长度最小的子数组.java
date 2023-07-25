package Array.sub_array;

import java.util.Arrays;

// https://leetcode.cn/problems/minimum-size-subarray-sum/
public class _209长度最小的子数组 {

    // n个正整数 , 滑动窗口解法
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0 , r = 0;
        int sum = 0;
        int res = 0;
        while (r < n){
            sum += nums[r];
            r++;
            while (sum >= target) {
                res = Math.min(res , r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return res;
    }

}
