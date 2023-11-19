package Algorithm.slide_windows;


// https://leetcode.cn/problems/minimum-size-subarray-sum/description/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _209_长度最小的子数组 {

    //给定一个含有 n 个正整数的数组和一个正整数 target 。
    //
    //找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
    //
    //
    //
    //示例 1：
    //
    //输入：target = 7, nums = [2,3,1,2,4,3]
    //输出：2
    //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    //示例 2：
    //
    //输入：target = 4, nums = [1,4,4]
    //输出：1
    //示例 3：
    //
    //输入：target = 11, nums = [1,1,1,1,1,1,1,1]
    //输出：0



    @Test
    void test(){
        Assertions.assertEquals(minSubArrayLen(7 , new int[]{2,3,1,2,4,3}) , 2);
        Assertions.assertEquals(minSubArrayLen(4 , new int[]{1,4,4}) , 1);
        Assertions.assertEquals(minSubArrayLen(11 , new int[]{1,1,1,1,1,1,1,1}) , 0);
    }


    /*
    * 思路：最小子数组问题，且数组中都为正数，复合单调性： [i , j] 满足条件 >= target , [i之前 , j] 就不需要考虑了
    *
    * */

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0 , r = 0;
        int sum = 0;
        while (r < nums.length){
            sum += nums[r];
            // 满足条件
            while (sum >= target){
                // 更新res
                if (r - l + 1 < res) res = r - l + 1;

                // 移动左指针
                sum -= nums[l++];
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
