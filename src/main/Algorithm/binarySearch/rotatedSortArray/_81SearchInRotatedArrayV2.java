package Algorithm.binarySearch.rotatedSortArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _81SearchInRotatedArrayV2 {


    @Test
    void test(){
        Assertions.assertEquals(search(new int[]{2,5,6,0,0,1,2}, 0) , true);
        Assertions.assertEquals(search(new int[]{2,5,6,0,0,1,2}, 3) , false);
        Assertions.assertEquals(search(new int[]{2,2,2,3,2,2,2}, 3) , true);
    }


    // 旋转数组中是否存在某个数，
    // 数组存在重复数字
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int l = 0 , r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] < nums[r]){
                // 45123
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid;
            }else if (nums[mid] > nums[r]){
                // 34512
                if (nums[l] <= target && target <= nums[mid]) r = mid;
                else l = mid + 1;
            }else r--;
        }
        return nums[l] == target;
    }
}
