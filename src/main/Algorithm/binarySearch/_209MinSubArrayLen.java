package Algorithm.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _209MinSubArrayLen {


    @Test
    void test(){
//        Assertions.assertEquals(minSubArrayLen(7  , new int[]{2,3,1,2,4,3}) , 2);
//        Assertions.assertEquals(minSubArrayLen(4  , new int[]{1,4,4}) , 1);
//        Assertions.assertEquals(minSubArrayLen(15  , new int[]{2,14}) , 2);
//        Assertions.assertEquals(minSubArrayLen(11  , new int[]{1,1,1,1,1,1,1,1}) , 0);
//
//
//        Assertions.assertEquals(minSubArrayLenV2(7  , new int[]{2,3,1,2,4,3}) , 2);
//        Assertions.assertEquals(minSubArrayLenV2(4  , new int[]{1,4,4}) , 1);
//        Assertions.assertEquals(minSubArrayLenV2(15  , new int[]{2,14}) , 2);
//        Assertions.assertEquals(minSubArrayLenV2(11  , new int[]{1,1,1,1,1,1,1,1}) , 0);
        Assertions.assertEquals(minSubArrayLenV2(5  ,  new int[]{2,3,1,1,1,1,1}) , 2);
    }



    // 和 >= target 的最小子数组长度, 不存在返回0
    // 二分猜答案
    public int minSubArrayLen(int target, int[] nums) {

        int l = 1 , r = nums.length;
        while (l < r){
            int mid = l + r >> 1;
            //System.out.println("mid" + mid);
            if (check(mid , nums , target)) r = mid;
            else l = mid+1;
        }

        if (l == nums.length){
            int sum = 0;
            for(int num : nums) sum += num;
            if (sum >= target) return nums.length;
            else return 0;
        }
        return l;
    }


    // 判断 nums 中 长度为 len 的子数组 是否有满足条件的
    // 长度为 size 的窗口
    private boolean check(int size, int[] nums , int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) sum -= nums[i - size];
            sum += nums[i];
            if (sum >= target) return true;
        }
        return false;
    }




    // 解法2：因为全是正整数，所以可以直接用 滑动窗口
    public int minSubArrayLenV2(int target, int[] nums){
         int l = 0 , r = 0;
         int sum = 0;
         int res = nums.length + 1;
         while (r < nums.length){
             sum += nums[r];
             while (sum >= target){
                 res = Math.min(res , r - l + 1);
                 sum -= nums[l++]; // 左指针移动
             }
             r++;
         }
         return res  == nums.length+1 ? 0 : res;

    }


}
