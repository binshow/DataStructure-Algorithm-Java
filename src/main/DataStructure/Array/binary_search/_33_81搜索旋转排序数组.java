package DataStructure.Array.binary_search;

public class _33_81搜索旋转排序数组 {




    // https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
    // 数组中存在重复元素
    //输入：nums = [2,5,6,0,0,1,2], target = 0
    //输出：true
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int l = 0 ,  r = nums.length-1;
        while (l < r){
            int mid = (l + r) >> 1;
            if (nums[mid] < nums[r]){  // 51234
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid;
            }else if (nums[mid] > nums[r]){ // 34512
                if (nums[l] <= target && target <= nums[mid]) r = mid;
                else l = mid+1;
            }else r--;
        }
        return nums[l] == target;
    }
}
