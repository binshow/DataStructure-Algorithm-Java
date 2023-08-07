package DataStructure.Array._二分查找;

public class _153_154旋转排序数组的最小值 {

    // https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
    public int findMin(int[] nums) {

        int l = 0 , r = nums.length - 1;
        while(l < r){
            int mid = l + r >> 1;
            //  5 1 2 3 4
            if(nums[mid] < nums[r]){
                r = mid;
            }else l = mid + 1;  // 3 4 5 1 2
        }
        return nums[l];

    }
}
