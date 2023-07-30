package DataStructure.Array._双指针._左右指针;



//  https://leetcode.cn/problems/container-with-most-water/
public class _11盛最多水的容器 {


    // 输入：[1,8,6,2,5,4,8,3,7]
    //输出：49
    //解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
    // 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    public int maxArea(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int n = nums.length;
        int l = 0 , r = n-1;
        int res = 0;
        while (l < r){

            // 更新结果
            int tem = Math.min(nums[l] , nums[r]);
            res = Math.max(res , (r - l ) * tem);

            // 那边更小移动哪边
            if (nums[l] < nums[r]) l++;
            else r--;
        }
        return res;

    }
}
