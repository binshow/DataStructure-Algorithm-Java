package Algorithm.binarySearch;

import java.util.Arrays;

public class _34FindFirstAndLastPosition {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 2, 3, 5}, 2)));
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums == null || nums.length == 0) return res;
        // find first position
        int l = 0 , r = nums.length-1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] < target){
                l = mid + 1;
            }else r = mid;
        }
        if (nums[l] != target) return res;
        res[0] = l;

        // find last position
         l = 0;
         r = nums.length-1;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (nums[mid] > target) r = mid-1;
            else l = mid;
        }
        res[1] = r;
        return res;
    }

}
