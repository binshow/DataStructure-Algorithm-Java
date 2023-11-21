package Algorithm.slide_windows;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

// https://leetcode.cn/problems/binary-subarrays-with-sum/description/
public class _930_和相同的二元子数组 {


    //给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。子数组 是数组的一段连续部分。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,0,1,0,1], goal = 2
    //输出：4
    //解释：
    //有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
    //示例 2：
    //
    //输入：nums = [0,0,0,0,0], goal = 0
    //输出：15


    @Test
    void test(){
        Assertions.assertEquals(numSubarraysWithSum(new int[]{1,0,1,0,1} , 2) , 4);
    }


    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int l = 0 , r = 0;
        int sum = 0;
        while (r < nums.length){
            sum += nums[r];

            while (sum >= goal){
                sum -= nums[l];
                if (sum == goal) res++;
                l++;
            }
            if (sum == goal) {
                // System.out.println( "l = " + l + " r = " + r);
                res++;
            }

            r++;
        }
        return res;
    }

}
