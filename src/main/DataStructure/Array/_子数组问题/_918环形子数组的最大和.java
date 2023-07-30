package DataStructure.Array._子数组问题;


//https://leetcode.cn/problems/maximum-sum-circular-subarray/

public class _918环形子数组的最大和 {


    //1. 没有环的情况：最近求子数组最大和
    //2. 包含环的情况：数组和 - 无环子数组最小值

    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int sum = 0 , curMax = 0 , max = Integer.MIN_VALUE , curMin = 0 , min = Integer.MAX_VALUE;
        for (int num : nums){
            sum += num;

            if (curMax > 0) curMax += num;
            else curMax = num;

            max = Math.max(max , curMax);

            if (curMin < 0) curMin += num;
            else curMin = num;

            min = Math.min(min , curMin);

        }

        if (max < 0) return max;

        return Math.max(max , sum - min);
    }
}
