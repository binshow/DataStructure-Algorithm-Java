package Algorithm.two_pointers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.cn/problems/3sum/description/
public class _15_3sum {


    // 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    // 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。

    //示例 1：
    //
    //输入：nums = [-1,0,1,2,-1,-4]
    //输出：[[-1,-1,2],[-1,0,1]]
    //解释：
    //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
    //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
    //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
    //不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
    //注意，输出的顺序和三元组的顺序并不重要。
    //示例 2：
    //
    //输入：nums = [0,1,1]
    //输出：[]
    //解释：唯一可能的三元组和不为 0 。
    //示例 3：
    //
    //输入：nums = [0,0,0]
    //输出：[[0,0,0]]
    //解释：唯一可能的三元组和为 0 。

    @Test
    void test(){

        Assertions.assertEquals(threeSum(new int[]{-1,0,1,2,-1,-4}).toString() , "[[-1, -1, 2], [-1, 0, 1]]");

    }

    // 思路：排序，然后双指针

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i + 1;
            int R = n - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i] , nums[L] , nums[R]));
                    while (L < R && nums[L] == nums[L+1]) L++; //去重
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                } else if (sum > 0) R--;
                else L++;
            }
        }
        return res;
    }

}
