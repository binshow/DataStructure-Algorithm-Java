package Algorithm.slide_windows;


// https://leetcode.cn/problems/longest-turbulent-subarray/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _978_最大湍流子数组 {

    //给定一个整数数组 arr ，返回 arr 的 最大湍流子数组的长度 。
    //
    //如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是 湍流子数组 。
    //
    //更正式地来说，当 arr 的子数组 A[i], A[i+1], ..., A[j] 满足仅满足下列条件时，我们称其为湍流子数组：
    //
    //若 i <= k < j ：
    //当 k 为奇数时， A[k] > A[k+1]，且
    //当 k 为偶数时，A[k] < A[k+1]；
    //或 若 i <= k < j ：
    //当 k 为偶数时，A[k] > A[k+1] ，且
    //当 k 为奇数时， A[k] < A[k+1]。
    //
    //
    //示例 1：
    //
    //输入：arr = [9,4,2,10,7,8,8,1,9]
    //输出：5
    //解释：arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
    //示例 2：
    //
    //输入：arr = [4,8,12,16]
    //输出：2
    //示例 3：
    //
    //输入：arr = [100]
    //输出：1



    /*
    * dp 思路：两个独立的dp状态 和 152 https://leetcode.cn/problems/maximum-product-subarray/ 思路相似
    *
    * dp1[i] 表示以 nums[i] 结尾且 nums[i-1] > nums[i] 的最大湍流子数组的长度
    * dp2[i] 表示以 nums[i] 结尾且 nums[i-1] < nums[i] 的最大湍流子数组的长度
    *
    *
    * */
    public int maxTurbulenceSize(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        //以 arr[i] 结尾，并且 arr[i - 1] < arr[i] 的湍流子数组的长度
        int[] f = new int[n];

        // 以 arr[i] 结尾，并且 arr[i - 1] > arr[i] 的湍流子数组的长度
        int[] g = new int[n];

        // base case
        f[0] = 1;
        g[0] = 1;

        int res = 1;

        // 递推关系
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                f[i] = g[i-1] + 1;
                g[i] = 1;
            } else if (nums[i] < nums[i-1]) {
                g[i] = f[i-1] + 1;
                f[i] = 1;
            } else {
                f[i] = 1;
                g[i] = 1;
            }

            res = Math.max(res , Math.max(f[i] , g[i]));
        }

         System.out.println(Arrays.toString(g));
        System.out.println(Arrays.toString(f));
        return res;
    }




}
