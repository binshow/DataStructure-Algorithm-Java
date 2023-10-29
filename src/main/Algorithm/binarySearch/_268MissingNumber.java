package Algorithm.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class _268MissingNumber {


    // Given an array nums containing n distinct numbers in the range [0, n],
    // return the only number in the range that is missing from the array.

    @Test
    void test(){
        Assertions.assertEquals(missingNumber(new int[]{3,0,1}) , 2);
        Assertions.assertEquals(missingNumber(new int[]{0,1}) , 2);
        Assertions.assertEquals(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}) , 8);
    }

    // 解法1： 【0-n】之间的数据范围，可以直接使用 数组的原地哈希
    //         原地哈希是指 通过  i  和  nums[i] 两个索引位置的交换 来使得元素的位置 等于下标的位置
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 0 && nums[i] < n && nums[i] != nums[nums[i]]){
                System.out.println("nums[i]: " + nums[i] + " i :" + i);

//                int tmp = nums[nums[i]];
//                nums[nums[i]] = nums[i];
//                nums[i] = tmp;

//                int tmp = nums[i];
//                nums[i] = nums[nums[i]];
//                nums[nums[i]] = tmp;
               swap(nums , i , nums[i]);
            }
        }

        System.out.println(Arrays.toString(nums));

        // 第一个和下标不符合的数据就是缺少的数字
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }
        return n;

    }

    void swap(int[] nums , int a , int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
