package Algorithm.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _162FindPeakElement {

    @Test
    void test(){
        Assertions.assertEquals(findPeakElement(new int[]{1,2,3,1}) , 2);
        Assertions.assertEquals(findPeakElement(new int[]{1,2,1,3,5,6,4}) , 5);
    }

    // 寻找峰值元素
    public int findPeakElement(int[] nums) {
        int l = 0 , r = nums.length-1;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (nums[mid] > nums[mid-1]){  // 1 2 3 1
                l = mid;
            }else r = mid - 1;
        }
        return l;
    }


}
