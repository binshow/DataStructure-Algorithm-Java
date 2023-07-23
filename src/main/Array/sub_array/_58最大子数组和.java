package Array.sub_array;


// https://leetcode.cn/problems/maximum-subarray/

public class _58最大子数组和 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums){
            if (sum > 0) sum += num;
            else sum = num;

            res = Math.max(res , sum);
        }
        return res;

    }


}
