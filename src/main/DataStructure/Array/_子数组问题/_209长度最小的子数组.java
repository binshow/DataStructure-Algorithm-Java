package DataStructure.Array._子数组问题;

// https://leetcode.cn/problems/minimum-size-subarray-sum/
public class _209长度最小的子数组 {

    // n个正整数 , 滑动窗口解法

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = n+1;
        int l = 0 , r = 0;
        int sum = 0;
        while(r < n){
            sum += nums[r];
            r++;
            while(sum >= target){
                res = Math.min(res , r - l);
                sum -= nums[l];
                l++;
            }
        }
        return res == n+1 ? 0 : res;

    }

}
