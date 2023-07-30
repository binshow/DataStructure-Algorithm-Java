package DataStructure.Array._子数组问题;

public class _581最短无序连续子数组 {


    //https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/

    // 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    //
    //请你找出符合题意的 最短 子数组，并输出它的长度。
    //

    // 输入：nums = [2,6,4,8,10,9,15]
    //输出：5
    //解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

    public int findUnsortedSubarray(int[] nums) {


        // 从左往右遍历，找到最大值前面一个数
        int l = 0 , r = 0;
        int min = nums[0] , max = nums[0];
        int n = nums.length;
        for(int i = 1 ; i <  nums.length ; i++){
            if (nums[i] > max) {
                max = nums[i];
                r = i-1;
            }
        }

        // 从右往左遍历，找到最小值后面一个数
        for (int i = n-1; i >= 0 ; i--) {
            if (nums[i] < min){
                min = nums[i];
                l = i+1;
            }
        }

        System.out.println("左边界: " + nums[l]  + ", 右边界: " + nums[r]);

        return r - l + 1;

    }
}
