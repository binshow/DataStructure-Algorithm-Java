package Algorithm.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class _287FindTheDuplicateNumber {


    //Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    //
    //There is only one repeated number in nums, return this repeated number.
    //
    //You must solve the problem without modifying the array nums and uses only constant extra space.
    //
    //Example 1:
    //
    //Input: nums = [1,3,4,2,2]
    //Output: 2
    //Example 2:
    //
    //Input: nums = [3,1,3,4,2]
    //Output: 3

    @Test
    void test(){
        Assertions.assertEquals(findDuplicate(new int[]{1,3,4,2,2}) , 2);
        Assertions.assertEquals(findDuplicate(new int[]{3,1,3,4,2}) , 3);
    }


    // 数据范围 【1，n】---> 原地哈希
    // i 和 nums[i]-1 相互交换
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i]-1]){
                swap(nums , i , nums[i] - 1);
            }
        }

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1) return nums[i];
        }
        return n;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
