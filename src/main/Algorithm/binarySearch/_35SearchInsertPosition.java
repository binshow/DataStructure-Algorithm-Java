package Algorithm.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _35SearchInsertPosition {


    @Test
    void test(){
        Assertions.assertEquals(searchInsert(new int[]{1,3,5,6} , 2) , 1);
        Assertions.assertEquals(searchInsert(new int[]{1,3,5,6} , 7) , 4);
    }


    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;
        if (nums[n-1] < target) return n;
        // search first position
        int l = 0 , r = n - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
