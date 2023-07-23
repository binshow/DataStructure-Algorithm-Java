package binary_search;


// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/

public class _34查找第一个和最后一个 {


    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0) return new int[]{-1,-1};
        res[0] = getFirst(nums , target);
        res[1] = getLast(nums , target);
        return res;
    }

    private int getLast(int[] nums, int target) {
        int l = 0 , r = nums.length-1;
        while (l < r){
            int mid = (l + r + 1) >> 1;
            if (nums[mid] > target) r = mid-1;
            else l = mid;
        }
        return nums[l] == target ? l : -1;
    }

    private int getFirst(int[] nums, int target) {
        int l = 0 , r = nums.length-1;
        while (l < r){
            int mid = (l + r) >> 1;
            if (nums[mid] < target) l = mid+1;
            else r = mid;
        }
        return nums[l] == target ? l : -1;
    }

}
