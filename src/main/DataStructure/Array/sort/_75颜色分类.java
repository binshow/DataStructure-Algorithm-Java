package DataStructure.Array.sort;

import java.util.Arrays;

// https://leetcode.cn/problems/sort-colors/
public class _75颜色分类 {


    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 0: 红色
    // 1: 白色
    // 2: 蓝色
    public static void sortColors(int[] nums) {
        int l = 0 , r = nums.length-1 , base = 1;
        int less = l -1 , more = r;
        int cur = l;
        while (cur < more){
            if (nums[cur] < base) swap(nums , ++less , cur++);
            else if (nums[cur] > base) swap(nums , more-- , cur);
            else cur++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
