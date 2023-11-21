package Algorithm.slide_windows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

//https://leetcode.cn/problems/max-consecutive-ones-iii/description/
public class _1004_最长连续1的个数_v3 {


    //给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    //输出：6
    //解释：[1,1,1,0,0,1,1,1,1,1,1]
    //粗体数字从 0 翻转到 1，最长的子数组长度为 6。
    //示例 2：
    //
    //输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
    //输出：10
    //解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    //粗体数字从 0 翻转到 1，最长的子数组长度为 10。


    @Test
    void test(){
        Assertions.assertEquals(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0} , 2 ) , 6);
        Assertions.assertEquals(longestOnes(new int[]{0,0,0,0} , 0 ) , 0);
        Assertions.assertEquals(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1} , 3 ) , 10);

    }



    /*
    *  窗口内不满足条件
    *
    * */

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int[] count = new int[2]; // count[0] 表示 0的个数 ， count[1] 表示1的个数
        int res = 0;
        int l = 0 , r = 0;
        while (r < n){
            if (nums[r] == 1) count[1]++;
            else count[0]++;

            while (l < r && count[0] > k){
                if (nums[l] == 1) count[1]--;
                else if (nums[l] == 0) count[0]--;
                l++;
            }

            //System.out.println("l " + l + " r " + r);
            if (r - l + 1 > res && count[1] > 0) res = r - l + 1;
            r++;
        }
        return res;

    }

}
