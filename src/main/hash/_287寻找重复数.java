package hash;

import java.util.Arrays;

public class _287寻找重复数 {

    //https://leetcode.cn/problems/find-the-duplicate-number/
    // 数字范围 [1,n]
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
                swap(nums , i , nums[i]-1);
        }
        System.out.println(Arrays.toString(nums));
        for(int i = 0 ; i < n ; i++) if (nums[i] != i+1) return i+1;
        return n;
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

}
