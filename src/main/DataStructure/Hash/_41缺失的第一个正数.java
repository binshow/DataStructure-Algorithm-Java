package DataStructure.Hash;


import java.util.Arrays;

// https://leetcode.cn/problems/first-missing-positive/
public class _41缺失的第一个正数 {

    //给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
    //
    //请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。

    //输入：nums = [3,4,-1,1]
    //输出：2

    public static int firstMissingPositive(int[] nums) {
        // 以数组的下标作为哈希表
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while( nums[i] > 0 &&  nums[i] < n && nums[i] != nums[nums[i]-1]){
//                int temp = nums[i];
//                nums[i] = nums[nums[i]-1];
//                nums[nums[i]-1] = temp;
                System.out.println("swap i: " + i + " j:" + (nums[i] - 1));
                swap(nums , i , nums[i] - 1);
            }
        }

        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1) return i+1;
        }

        return n+1;
    }

    private static void swap(int[] nums, int a, int b) {
        int tem = nums[a];
        nums[a] = nums[b];
        nums[b] = tem;
    }


    public static void main(String[] args) {
        //System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, 1 , -1}));
        System.out.println(firstMissingPositive(new int[]{2,1,3}));
        System.out.println(firstMissingPositive(new int[]{7,8,9}));
    }
}
