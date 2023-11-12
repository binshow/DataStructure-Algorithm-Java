package Algorithm.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//https://leetcode.cn/problems/3sum-closest/description/
public class _16_3sum_closest {


    //给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
    //
    //返回这三个数的和。
    //
    //假定每组输入只存在恰好一个解。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [-1,2,1,-4], target = 1
    //输出：2
    //解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
    //示例 2：
    //
    //输入：nums = [0,0,0], target = 1
    //输出：0

    @Test
    void test(){

    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int L = i + 1;
            int R = nums.length-1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(res - target) > Math.abs(sum - target)) res = sum;
                if (sum == target) return target;
                else if (sum > target) R--;
                else L++;
            }
        }
        return res;
    }
}
