package Algorithm.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//https://leetcode.cn/problems/find-peak-element/description/

public class _162_寻找峰值 {

    @Test
    void test(){
        Assertions.assertEquals(findPeakElement(new int[]{1,2,3,1}) , 2);
        Assertions.assertEquals(findPeakElement(new int[]{1,2,1,3,5,6,4}) , 5);
    }



    // 峰值元素 比 左边大，比 右边小
    public int findPeakElement(int[] nums) {
        int l = 0 , r = nums.length-1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            // mid 比左边的大 ，说明 mid 处于递增的阶段，mid也可能是峰顶
            if(mid > 0 && nums[mid] > nums[mid-1]) l = mid;
            else r = mid-1;
        }
        return l;
    }


}
