package DataStructure.Array._子序列问题;

public class _674最长递增子数组 {

    // https://leetcode.cn/problems/longest-continuous-increasing-subsequence/

    // 输入：nums = [1,3,5,4,7]
    //输出：3
    //解释：最长连续递增序列是 [1,3,5], 长度为3。
    //尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。


    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) count++;
            else count = 0;
            res = Math.max(count , res);
        }
        return res;

    }
}
