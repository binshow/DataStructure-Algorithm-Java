package Algorithm.binarySearch.rotatedSortArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _154FindMinimumInRotatedArrayV2 {

    @Test
    void test(){
        Assertions.assertEquals(findMin(new int[]{3,4,5,1,2}) , 1);

    }


    // 旋转排序数组
    // 数组中存在重复数
    public int findMin(int[] nums) {
        int l = 0 , r = nums.length-1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] < nums[r]){
                // 45123
                r = mid;     // mid 可能是最小值
            }else if (nums[mid] > nums[r]){
                // 34512
                l = mid + 1;
            }else r--;
        }
        return nums[r];
    }
}
