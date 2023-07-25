package hash;

import java.util.Arrays;

public class _268丢失的数字 {

    //https://leetcode.cn/problems/missing-number/

    //给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

    public int missingNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            while (nums[i] >= 0 && nums[i] < n && nums[i] != nums[nums[i]]) swap(nums , i , nums[i]);
        }

        System.out.println(Arrays.toString(nums));

        for(int i = 0 ; i < n ; i++){
            if (nums[i] != i) return i;
        }
        return n;
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }


}
